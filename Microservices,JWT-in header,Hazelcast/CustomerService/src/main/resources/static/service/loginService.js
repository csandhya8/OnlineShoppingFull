microservice.service("loginService", function($http,$location) {
	
	var responsePromise =null;
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
	
	this.getUserDetails=function(username, password, callback){
		alert("username"+username);
		var user = {
				"userName" : username,
				"password" : password
			};	
		if((username=="admin" || username=="test" || username =="user")&&(password=="password")){
			
		
		var responsePromise = $http({
			url : "http://localhost:9090/customerservice/customer/getCustomer",
			method : "POST",
			data : user,
			headers : {
				'Content-Type' : 'application/json'
			}
		});
		}
		else{
			alert("UserName or Password is wrong");
		}
		responsePromise.success(function(data, status, headers, config) {
			
			callback(data);

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});
		
		
	}	
	
	

	this.generateJwtToken = function(username, password, callback) {
	
	
		
		var user = {
				"userName" : username,
				"password" : password
			};	
		if((username=="admin" || username=="test" || username =="user")&&(password=="password")){
	
		responsePromise = $http({
			url : "http://localhost:9090/authservice/loginService/generateToken",
			method : "POST",
			data : user,
			headers : {
				'Content-Type' : 'application/json',
				'Access-Control-Allow-Origin': 'http://localhost:9090',
				'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, HEAD'
			}
			
		});

		}
		else{
	
			alert("UserName or Password is wrong");
		}
		responsePromise.success(function(data, status, headers, config) {
			
			callback(data);
			

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});

	}

});
