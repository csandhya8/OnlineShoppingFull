package com.techm.customerservice.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetCustomer  extends HystrixCommand<String> {
	
	public GetCustomer(){
		super(HystrixCommandGroupKey.Factory.asKey("Get CustomerService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Get CustomerService");
	        return "Get CustomerService";
	    }

}
