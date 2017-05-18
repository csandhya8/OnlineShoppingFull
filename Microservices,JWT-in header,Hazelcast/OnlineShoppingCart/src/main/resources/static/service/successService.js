microservice.service("successService", function($http, $location, loginService) {

	

	this.saveOrder = function(jwttoken,callback) {
		
		var responsePromise = $http({
			url : "http://172.18.32.167:9090/order-service/orders/createOrder",
			method : "POST",
			
			headers : {
				'Content-Type' : 'application/json',
				
				'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
			
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
