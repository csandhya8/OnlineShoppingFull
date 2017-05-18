microservice.service("shippingService", function($http, $location,$cookieStore) {
	
	this.getShippingStatus=function(jwttoken,orderId,callback){
		var responsePromise = $http({	url:"http://172.18.32.167:9090/shipping-service/shipping/getShippingStatus?orderId="+orderId,
			method: "GET",
			headers: { 	'Content-Type': 'application/json',
			
				'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
				
			'jwtToken' : jwttoken
		}		   });
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
		var responsePromise = 	 $http({	url: "http://172.18.32.167:9090/shipping-service/shipping/create", 
			method: "POST", 
			data: shipping,
			headers: { 	'Content-Type': 'application/json',
				
				'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
			
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