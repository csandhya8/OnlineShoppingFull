package com.techm.customerservice.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CreateCustomerService extends HystrixCommand<String> {
	
	public CreateCustomerService(){
		super(HystrixCommandGroupKey.Factory.asKey("Create CustomerService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Create CustomerService");
	        return "Create CustomerService";
	    }
}
