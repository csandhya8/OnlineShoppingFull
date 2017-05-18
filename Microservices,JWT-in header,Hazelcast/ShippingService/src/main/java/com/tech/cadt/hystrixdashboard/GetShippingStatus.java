package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetShippingStatus extends HystrixCommand<String> {
	
	public GetShippingStatus(){
		super(HystrixCommandGroupKey.Factory.asKey("Get ShippingStatus"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Get ShippingStatus");
	        return "Get ShippingStatus";
	    }

}
