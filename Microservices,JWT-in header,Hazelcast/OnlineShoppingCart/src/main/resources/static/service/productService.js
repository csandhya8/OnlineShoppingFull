microservice.service("productService", function($http, $location,$cookieStore) {
	
	var product = {};
	
	this.setProduct = function(selectedProduct) {
		$cookieStore.put('selectproduct', selectedProduct);
		product = selectedProduct;
	};
	
	this.getProduct = function() {
		return product;
	};	
	
	var orderedproduct = {};

	this.setorderedproduct = function(count) {
		$cookieStore.put('productobj', count);
		orderedproduct = count;
	};

	this.getorderedproduct = function() {
		return orderedproduct;
	};
	
	var productOrder = {};
	
	this.setProductSelected = function(productordered) {
		productOrder = productordered;
	};

	this.getProductSelected = function() {
		return productOrder;
	};
	
	this.getdata = function(jwttoken,callbackData) {
		
		var responsePromise = $http({
			url:"http://172.18.32.167:9090/catalogue-service/catalogueService/read-all",
			method: "GET",
			headers: { 	'Content-Type': 'application/json',
				
				
				'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
				
				
			'jwtToken' : jwttoken
		}		   
});
		responsePromise.success(function(data, status, headers, config) {
			alert("SUCCESS!!!");
		callbackData(data);
		});
		responsePromise.error(function(data, status, headers, config) {
		alert("AJAX failed! because no webservice is attached yet in catalogue service:"+responsePromise);				
		});
	};
	
	this.updateProduct=function(id,availableItems,jwttoken,callback){
	
		var productUpdate = {
				"id" : id,
				"availableitems" : availableItems
			};			
				
			var responsePromise = 	 $http({	url: "http://172.18.32.167:9090/catalogue-service/catalogueService/update", 
				method: "POST", 
				data: productUpdate,
				headers: { 	'Content-Type': 'application/json',
					'Connection': 'keep-alive',
					
					'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
					'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD',
					
							'jwtToken' : jwttoken
						}		   
			 });
			
			
			responsePromise.success(function(data, status, headers, config) {		
				callback(data);

			});
			
			
			responsePromise.error(function(data, status, headers, config) {
				alert("AJAX failed! because no webservice is attached yet");
			});
			
			
	};
});