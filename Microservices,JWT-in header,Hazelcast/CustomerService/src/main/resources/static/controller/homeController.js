microservice.controller('homeController', function($scope, $window,$route,$location) {

	$scope.cancel = function() {
		$location.path("/");
		
		window.location.reload();
		
	};
	
	
	$scope.logout = function() {
		$location.path("/");
		
		window.location.reload(); 
		
	};
	
	
	
	/*$scope.login = function() {       

	        self.animationsEnabled = true;
	        var modalInstance = $uibModal
	            .open({
	                animation: self.animationsEnabled,

	                windowClass: 'medium-Modal',
	                size: 'md',

	                controller: 'loginController',
	                controllerAs: 'loginController',
	                templateUrl: 'views/login.html'

	            });

	        self.toggleAnimation = function() {
	            self.animationsEnabled = !$self.animationsEnabled;
	        };
	        modalInstance.result.then(function() {


	        }, function() {});

	    };*/
});


