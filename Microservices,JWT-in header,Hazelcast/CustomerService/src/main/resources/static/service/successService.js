microservice.service("successService", function($http, $location, loginService) {

	

	this.saveOrder = function(jwttoken,callback) {
		
		var responsePromise = $http({
			url : "http://localhost:9090/orderservice/orders/createOrder",
			method : "POST",
			
			headers : {
				'Content-Type' : 'application/json',
				"jwttoken" : jwttoken
			}
		});

		responsePromise.success(function(data, status, headers, config) {
			alert("Inside Order service with jwt token");
	
			callback(data);

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});

	}
	
	


});
