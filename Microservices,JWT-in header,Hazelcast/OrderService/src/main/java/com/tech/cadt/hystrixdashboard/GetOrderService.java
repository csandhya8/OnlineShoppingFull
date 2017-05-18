package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetOrderService extends HystrixCommand<String> {
	
	public GetOrderService(){
		super(HystrixCommandGroupKey.Factory.asKey("Get OrderService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Get OrderService");
	        return "Get OrderService";
	    }

}
