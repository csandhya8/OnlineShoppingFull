microservice.controller('successController',function($scope,$window,$location,$route, loginService,$cookieStore,successService,$rootScope) {
	
	$rootScope.isLogin = true;
	$rootScope.isLogout=true;
	
	$scope.user_Details = JSON.parse($window.sessionStorage.getItem("user_Details"));
	$rootScope.customerName=$scope.user_Details.firstName+" "+$scope.user_Details.lastName;	
		

	$scope.logout=function(){
		
		$location.path("/logout");
		 $route.reload();
		 window.location.reload(); 
	};

	$scope.showSuccess = function() {
		   var jwtcookie =$cookieStore.get('cookiejwtToken');
		   if (jwtcookie != null) {
			  
			 
			   $scope.msg=jwtcookie;
			   
			   
		   }
		   else{
			   $location.path("/logout");
				 $route.reload();
				 window.location.reload(); 
			   
		   }
		   }
	$scope.cancel = function() {
		$location.path("/");
		 $route.reload();
		 window.location.reload(); 
	};
	
	

	
	$scope.order = function() {
		var jwtcookie =$cookieStore.get('cookiejwtToken');
		if (jwtcookie != null) {
			successService.saveOrder(jwtcookie, function(data) {
			if(data == null || data === "" ){
					
					$location.path("/login");
					$scope.error = true;
				}
				else if((data != null)){
					var tokenData=data.split('!')[0]; 
					alert("inside order controller : "+data);
					alert("inside order controller : "+tokenData);
					if(tokenData==="else"){
						
						$location.path("/login");
						$scope.error = true;
					}
					else if(tokenData==="if"){
						$location.path("/order");
						window.location.reload(); 
					}
					
				}
				 
					});
		}
	}
	
	

});
