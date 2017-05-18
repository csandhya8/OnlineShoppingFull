microservice.controller('loginController',function($scope, $location, $window,$route,loginService,$cookieStore,$rootScope){
	
 	$scope.error = false;
 	$rootScope.isLogin = false;
 	$rootScope.isLogout=false;

	$scope.success=function(data){
		$scope.msg=data;
		
	}
	$scope.login = function(){
			
		loginService.getUserDetails($scope.username, $scope.password, function(data){
			 $window.sessionStorage.setItem("user_Details", JSON
	                    .stringify(data));
		});
			loginService.generateJwtToken($scope.username, $scope.password, function(data){
			
			
			alert("Token : "+data);
			
				if (data != null) {
					$cookieStore.put('cookiejwtToken',data);
					loginService.setJwttoken(data);					
				
					
					if($cookieStore.get('cookiejwtToken') !=null){
					
						$scope.isLogin = true;
						$scope.isLogout=true;
						$scope.afterlogin="loggedin";
						$location.path("/success");
						window.location.reload(); 
						$scope.token=$cookieStore.get('cookiejwtToken');
						
					}
				}
					
				});
			
			
				
			
	
	};


   
    $scope.logout = function() {
    	 $cookieStore.remove('cookiejwtToken');
         
		 $location.path("/logout");
		 window.location.reload();
	};
		
	
});

