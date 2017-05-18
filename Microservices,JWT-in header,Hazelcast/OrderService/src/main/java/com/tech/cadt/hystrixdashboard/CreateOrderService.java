package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CreateOrderService extends HystrixCommand<String> {
	
	public CreateOrderService(){
		super(HystrixCommandGroupKey.Factory.asKey("Create OrderService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Create OrderService");
	        return "Create OrderService";
	    }
}
