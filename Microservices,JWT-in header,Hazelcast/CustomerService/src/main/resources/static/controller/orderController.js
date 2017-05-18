microservice.controller('orderController', function($scope,$rootScope,$window, $location,shippingService, productService,
		loginService,orderService,$cookieStore) {
	
	$rootScope.isLogin = true;
	$rootScope.isLogout=true;	
	
	$scope.showStatus=false;
	$scope.address;
	$scope.order;
	$scope.availableItems;
	
	$scope.user_Details = JSON.parse($window.sessionStorage.getItem("user_Details"));
	
	$scope.showInvoice = function() {
		
	
		$scope.address=$scope.user_Details.address;
		
		
		var jwtcookie =$cookieStore.get('cookiejwtToken');
		if (jwtcookie != null) {
		$scope.productcookie =   $cookieStore.get('Orderedproduct');		
		
		$scope.totalamt = $scope.productcookie.quantity * $scope.productcookie.cost;	
		$scope.availableItems=$scope.productcookie.availableitems-$scope.productcookie.quantity;
		
		}
	}
	
	$scope.trackOrder  = function() { 
		$scope.user_Details = JSON.parse($window.sessionStorage.getItem("user_Details"));
		orderService.trackOrderByCustomerID($scope.user_Details.customerid,function(data){			
			$scope.trackOrdered=data;
			
		});
	
	};
	
	$scope.shippingStatus=function(orderId){
		
		shippingService.getShippingStatus(orderId,function(data){
			$scope.showStatus=true;
			$scope.orderId=orderId;
			$scope.status=data;
		});
	};
	
	$scope.confirmOrder = function(paymentMode,address) {
		var jwtcookie =$cookieStore.get('cookiejwtToken');
		$scope.customerName=$scope.user_Details.firstName+" "+$scope.user_Details.lastName;	
		
	
		if (jwtcookie != null) {
			
	
			
			orderService.saveorder($scope.productcookie.id,$scope.user_Details.customerid,$scope.user_Details.userName, $scope.paymentMode, $scope.address, 
					$scope.productcookie.quantity, $scope.totalamt, $cookieStore.get('cookiejwtToken'),  function(data) {
					if (data != null ) {	
						 $window.sessionStorage.setItem("orderedDetails", JSON
				                    .stringify(data));
						
						 productService.updateProduct($scope.productcookie.id,$scope.availableItems,$cookieStore.get('cookiejwtToken'),function(data){
						 
						 
						 });
						 
						
						shippingService.saveShipping(data.orderId,$scope.user_Details.customerid, 
								$scope.customerName, $scope.user_Details.email, $scope.address,$scope.user_Details.phNumber,$cookieStore.get('cookiejwtToken'),function(data) {
							
							if (data != null ) {	
								$window.sessionStorage.setItem("shippedDetails", JSON
					                    .stringify(data));
							
								$location.path("/shipping");
							}
							else {
								$location.path("/login");
								$scope.error = true;
							}
						});
						orderService.setConfirmorder(data);						
						}
					else {
						$location.path("/login");
						$scope.error = true;
					}
					
				
			});
		
			
			
		}
		
	}
		
		
	

});
