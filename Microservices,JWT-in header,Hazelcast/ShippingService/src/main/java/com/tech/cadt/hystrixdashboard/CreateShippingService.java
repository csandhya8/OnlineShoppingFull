package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CreateShippingService extends HystrixCommand<String> {
	
	public CreateShippingService(){
		super(HystrixCommandGroupKey.Factory.asKey("Create ShippingService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Create ShippingService");
	        return "Create ShippingService";
	    }
}
