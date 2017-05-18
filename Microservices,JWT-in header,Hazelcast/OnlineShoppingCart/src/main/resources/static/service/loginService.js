microservice.service('loginService',['ip_config',function($http,$location,ip_config) {
	
	var responsePromise =null;
	var responsePromise1 =null;

	var jwttoken = {};
	this.setJwttoken = function(Jwttokendata) {
		jwttoken = Jwttokendata;
	}

	this.getJwttoken = function() {
		return jwttoken;
	}

	var  isLogin ={}
	this.setIsUserLogin  =function(isUserloggedin){
		isLogin  = this.isUserloggedin;
	}
	
	this.getIsUserLogin  =function(){
		return isLogin;
	}
	
	//alert("moment= "+moment);
	
this.getDisplayName = function(username, password, callback,ip_config){
	var value= ip_config;
	alert("ip_config= "+value);
	var user = {
			"userName" : username,
			"password" : password
		};	
	
	
	responsePromise1 = $http({
		url : "http://172.18.32.167:9090/customer-service/customer/getCust",
		//url : "http://localhost:8223/customer/getCust",
		method : "POST",
		data : user,
		headers : {
			'Content-Type' : 'application/json',
			
			'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
			'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD'
			
		}
		
	});
	
	
	
	responsePromise1.success(function(data, status, headers, config) {
		
	
		callback(data);		
			

		});
		responsePromise1.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet in getting firstName: "+responsePromise);
		});
	
};

	this.generateJwtToken = function(username, password, callback) {
	
	
		
		var user = {
				"userName" : username,
				"password" : password
			};	
		
		
		
	

		
		responsePromise = $http({
			url : "http://172.18.32.167:9090/jwt-service/loginService/generateToken",
			//url : "http://localhost:8221/loginService/generateToken",
			method : "POST",
			data : user,
			headers : {
				'Content-Type' : 'application/json',
				
				'Access-Control-Allow-Origin': 'http://172.18.32.167:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD'
				
			}
			
		});

		
		responsePromise.success(function(data, status, headers, config) {
			alert("jwt token= "+data);
			callback(data);	
	
		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet in login service generate jwt token: "+responsePromise);
		});

	}

}]);
