microservice.service("orderService", function($http, $location,$cookieStore,$window,loginService) {
	var orderId={};
	var confirmorder = {};
	this.setConfirmorder = function(selectedconfirmorder) {
		confirmorder = selectedconfirmorder;
	};
	this.getConfirmorder = function() {
		return confirmorder;
	};

	this.saveorder = function(productid,customerid, username, paymentMode, address,
			 orderQuantity, totalamt, jwttoken, callback) {
		
		
		
		var orderdetails = {
			"productId" : productid,
			"customerId":customerid,
			"username" : username,
			"paymentMode" : paymentMode,
			"billingAddress" : address,
			"deliveryAddr" : address,
			"orderQuantity" : orderQuantity,
			"totalAmt" : totalamt
		};
		
			
		var responsePromise = 	 $http({	url: "http://172.18.32.167:9090/order-service/orders/create", 
			method: "POST", 
			data: orderdetails,
			headers: { 	'Content-Type': 'application/json',
				
				'Access-Control-Allow-Origin': 'http://localhost:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
				
						/*'Access-Control-Allow-Origin': 'http://localhost:9090',
						'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',*/
						'jwtToken' : jwttoken} 	
   
		 });
		
		
		
		responsePromise.success(function(data, status, headers, config) {
			alert("Confirm Order Sucess"); 
			orderId=data.orderId;
			
		if(orderId!=null && orderId!=undefined && orderId!=""){
			callback(data,orderId);
		}else{
			$location.path("/login");
		}
			

		});
		
		
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet -> Not confirmed");
		});
		
		

	};
	
	this.trackOrderByCustomerID=function(jwttoken,customerId,callback){
		var input = {
				"customerId" : customerId	
		}
		var responsePromise =  $http({	url:"http://172.18.32.167:9090/order-service/orders/getOrderByCustomer",
			method: "POST",
			data:input,
			
			headers: { 	'Content-Type': 'application/json',
				
				'Access-Control-Allow-Origin': 'http://localhost:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
				
				
			'jwtToken' : jwttoken
		}		   
});
		responsePromise.success(function(data, status, headers, config) {	
		alert("success in trackOrderByCustomerID");
			callback(data);

		});
		
		
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});
		
		

	};
	
	
	
	
	

});
