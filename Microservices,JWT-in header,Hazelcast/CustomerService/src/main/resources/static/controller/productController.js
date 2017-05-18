microservice.controller('productController', function($scope, $window,$location,$route,$cookieStore,$rootScope,productService) {
	$scope.min = 1;
	$rootScope.isLogin = true;
	$rootScope.isLogout=true;	
	
	
	$scope.user_Details = JSON.parse($window.sessionStorage.getItem("user_Details"));
	
	$scope.getAllProducts = function() {		
		alert("inside all product");
		productService.getdata(function(data) {
			
			$scope.returndata = data;	
		});

	};

	$scope.buy = function(product) {
		productService.setProduct(product);
		$location.path("/productDetails");
		
	};
	
	$scope.showProduct = function(orderedproduct) {
		$scope.product  = $cookieStore.get('selectproduct');		
		$cookieStore.put('selectedproductcookie',$scope.product);
		$scope.selectproductcookie = $cookieStore.get('selectedproductcookie');
		productService.setorderedproduct(orderedproduct);
	};
	
	$scope.order = function(product) {
		productService.setProductSelected(true);
		$cookieStore.put('Orderedproduct',$scope.product);
		alert("ordered ...product::::::::::::"+JSON.stringify(product));
		var jwtcookie = $cookieStore.get('cookiejwtToken');
		if ($scope.loginuserstatus == "yes" || jwtcookie != null) {
			$location.path("/confirmOrder");
		}

		else{
			$location.path("/login");
		}
			
	};	

	$scope.showOrder = function() {
		var jwtcookie =$cookieStore.get('cookiejwtToken');
		if (jwtcookie != null) {		   
			
			$scope.msg=jwtcookie; 
			   
		}
		else{
			$location.path("/logout");
			$route.reload();
			window.location.reload(); 
		   }
	};
	
	
	$scope.cancel = function() {
		$location.path("/");
		$route.reload();
		window.location.reload(); 
	};
	
	
	
	

});
