microservice.controller('loginController',function($scope,$location,$route,loginService,$cookieStore,$rootScope,$window){
	  
 	$scope.error = false;
 	$rootScope.isLogin = false;
 	$rootScope.isLogout=false;
 	$scope.fistName=null;
 	$scope.lastName= null;
	$scope.success=function(data){
		$scope.msg=data;
		
	}
	//alert("ipAddress= "+moment);		
	$scope.login = function(){
		
		
		loginService.getDisplayName($scope.username, $scope.password, function(data){
			
			if(data!=null)
			angular.forEach(data, function(value, key) {
				 if(key=="userName"&&value==$scope.username){
					 angular.forEach(data, function(value, key) { 
					 if(key=="firstName")
						 $scope.fistName=value;
					 if(key=="lastName")
						 $scope.lastName=value;
					 
					 });	
					//alert("firstName= "+$scope.fistName+" "+"lastName= "+$scope.lastName);
					 $window.sessionStorage.setItem("user_Details", JSON
			                    .stringify($scope.fistName+" "+$scope.lastName));
					 
					 
				 }
				});
		
		});
		
		

			loginService.generateJwtToken($scope.username, $scope.password, function(data){
				alert("inside generating token");
			
			alert("Token : "+data);
			
				if (data!= null && data!="" ) {
					 /*$window.sessionStorage.setItem("user_Details", JSON
			                    .stringify($scope.username));*/
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
				
				else{
					
					alert("Username or password is wrong!!!!");
				}
					
				});
			
			
			
			
	
	};

	
	
    $scope.logout = function() {
    	 $cookieStore.remove('cookiejwtToken');
         
		 $location.path("/logout");
		 window.location.reload();
	};
		
	
});

