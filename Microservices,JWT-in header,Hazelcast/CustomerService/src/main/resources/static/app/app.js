var microservice = angular.module('microservice', ['ngRoute', 'ngCookies' ]);
microservice.config(['$routeProvider', function($routeProvider) {
    
	$routeProvider

	.when('/', {

		templateUrl : 'views/home.html',
		controller : 'homeController'
	})

	
	.when('/home', {

		templateUrl : 'views/home.html',
		controller : 'homeController'
	})

	

	.when('/login', {
		templateUrl : 'views/login.html',
		controller : "loginController"

	})
	
	.when('/success', {
		templateUrl : 'views/success.html',
		controller : "successController"

	})
	.when('/order', {
		templateUrl : 'views/order.html',
		controller : "orderController"

	})
	.when('/product', {

		templateUrl : 'views/catalogue.html',
		controller : 'productController'
	})
	.when('/productDetails', {

		templateUrl : 'views/productdetails.html',
		controller : 'productController'
	})
	.when('/confirmOrder', {
		templateUrl : 'views/confirmorder.html',
		controller : "orderController"

	})
	.when('/shipping', {
		templateUrl : 'views/shipping.html',
		controller : "shippingController"

	})
	.when('/trackOrder', {
		templateUrl : 'views/trackOrders.html',
		controller : "orderController"

	})
	.when('/logout', {
		templateUrl : 'views/home.html',
		controller : "homeController"

	})	

	.otherwise({
		redirectTo : '/'

	});
	
}

]);

