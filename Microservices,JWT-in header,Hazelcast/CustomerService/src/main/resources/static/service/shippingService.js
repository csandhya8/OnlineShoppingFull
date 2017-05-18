microservice.service("shippingService", function($http, $location,$cookieStore) {
	
	this.getShippingStatus=function(orderId,callback){
		var responsePromise = $http.get("http://localhost:9090/shippingservice/shipping/getShippingStatus?orderId="+orderId);
		
		responsePromise.success(function(data, status, headers, config) {
			
			callback(data);

		});
		
		
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});
	};
	
	this.saveShipping = function(orderId, customerid, customerName, email,
			address, phNumber, jwttoken,callback) {
		
		
		var shipping={
				"orderId":orderId,
				"customerid":customerid,
				"customerName":customerName,
				"emailId":email,
				"deliveryAddress":address,
				"mobileNumber":phNumber,
				"status":"Shipped"
		};
		var responsePromise = 	 $http({	url: "http://localhost:9090/shippingservice/shipping/create", 
			method: "POST", 
			data: shipping,
			headers: { 	'Content-Type': 'application/json',
				/*'Access-Control-Allow-Origin': 'http://localhost:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',*/
				'jwtToken' : jwttoken}
   	
   
		 });
		
		responsePromise.success(function(data, status, headers, config) {
			if(data!=null && data!=undefined && data!=""){
				callback(data);
			}else{
				$location.path("/login");
			}
			
		});
		
		
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});
		
	}
	
	
});