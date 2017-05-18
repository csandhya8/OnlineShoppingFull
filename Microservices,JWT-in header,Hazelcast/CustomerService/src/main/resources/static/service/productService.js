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
	
	this.getdata = function(callbackData) {
		
		var responsePromise = $http.get("http://localhost:9090/catalogueservice/catalogueService/read-all");
		responsePromise.success(function(data, status, headers, config) {
		callbackData(data);
		});
		responsePromise.error(function(data, status, headers, config) {
		alert("AJAX failed! because no webservice is attached yet");				
		});
	};
	
	this.updateProduct=function(id,availableItems,jwttoken,callback){
	
		var productUpdate = {
				"id" : id,
				"availableitems" : availableItems
			};			
				
			var responsePromise = 	 $http({	url: "http://localhost:9090/catalogueservice/catalogueService/update", 
				method: "POST", 
				data: productUpdate,
				headers: { 	'Content-Type': 'application/json',
							'Access-Control-Allow-Origin': 'http://localhost:9090',
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