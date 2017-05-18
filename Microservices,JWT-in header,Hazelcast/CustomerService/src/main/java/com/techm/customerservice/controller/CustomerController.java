package com.techm.customerservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techm.customerservice.entity.Customer;
import com.techm.customerservice.hystrixdashboard.CreateCustomerService;
import com.techm.customerservice.hystrixdashboard.GetCustomer;
import com.techm.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")

public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json")    
	public Customer create(@Valid @RequestBody Customer customer) {
		CreateCustomerService createCustomerService =new CreateCustomerService();
		createCustomerService.execute();	
		customer = customerRepository.save(customer);
	    return customer;
	}
	
	@RequestMapping(value="/getCust", method = RequestMethod.POST, produces = "application/json") 
	public Customer getCustomer(@Valid @RequestBody  String userCredentials) { //Customer customer ) {
	GetCustomer getCustomer = new GetCustomer();
	getCustomer.execute();	
	JSONObject userCredjson = null;
	userCredjson = new JSONObject(userCredentials.toString());
	String username=null;
	username = userCredjson.optString("userName");
	Customer cs=new Customer();
	
	cs=customerRepository.findByUserName(username);
	System.out.println("In /getCust value of cs is : "+cs);
	return cs;
	}

	@RequestMapping(value="/getCustomer", method = RequestMethod.POST, produces = "application/json") 
	public String getCustomerByName(@Valid @RequestBody String userCredentials) {
		JSONObject userCredjson = null;
		userCredjson = new JSONObject(userCredentials.toString());
		String username=null;
		String password=null;
		if (userCredjson != null) {
			 username = userCredjson.optString("userName");
			System.out.println("username in validating customer------"+username);
			System.out.println("userCredjson----"+userCredjson);
			 password = userCredjson.optString("password");
			System.out.println("Entered username ::"+username+"\t Entered password ::"+password);
		}
		
	GetCustomer getCustomer = new GetCustomer();
	getCustomer.execute();	
	String msg="wrongPassword";
	Customer cs=new Customer();
	try{
	cs=customerRepository.findByUserName(username);
	System.out.println("Inside validating customer- value of cs is= "+cs.getUserName()+"password: "+cs.getPassword());
	if(  (cs.getUserName().equals (username) ) && ( cs.getPassword().equals( password) )){
		
		msg="success";
		//System.out.println("Message in validated user: "+msg);
	}
	
	}catch(NullPointerException npe){
		msg="notAuthorized";	
	}
	System.out.println("Message: "+msg);
	return msg;
	}

}
