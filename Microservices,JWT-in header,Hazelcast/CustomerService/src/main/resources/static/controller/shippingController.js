microservice.controller('shippingController', function($scope,$window, $location,$route, loginService,$cookieStore,shippingService,successService,$rootScope) {
	
	
	$rootScope.isLogin = true;
	$rootScope.isLogout=true;
	$scope.showStatus=false;
	
	$scope.showShippingDetails=function(){
		$scope.productcookie =   $cookieStore.get('Orderedproduct');	
		$scope.orderedDetails = JSON.parse($window.sessionStorage.getItem("orderedDetails"));		
		$scope.shippedDetails = JSON.parse($window.sessionStorage.getItem("shippedDetails"));		
	
		
	}
	$scope.shippingStatus=function(orderId){
		
		shippingService.getShippingStatus(orderId,function(data){
			$scope.showStatus=true;
			$scope.orderId=orderId;
			$scope.status=data;
		});
	};
	$scope.showShipping = function() {
		   var jwtcookie =$cookieStore.get('cookiejwtToken');
		   if (jwtcookie != null) {
			   
			   $scope.msg=jwtcookie; 
			   
		   }
		   else
			   {
			   $location.path("/logout");
				 $route.reload();
				 window.location.reload(); 
			   }
		   
		   }
	$scope.cancel = function() {
		$location.path("/success");
		 
	};
	
	
	
	

});
