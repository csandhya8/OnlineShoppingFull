package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetOrderByCustomer  extends HystrixCommand<String> {
	
	public GetOrderByCustomer(){
		super(HystrixCommandGroupKey.Factory.asKey("Get OrderByCustomer"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Get OrderByCustomer");
	        return "Get OrderByCustomer";
	    }
}
