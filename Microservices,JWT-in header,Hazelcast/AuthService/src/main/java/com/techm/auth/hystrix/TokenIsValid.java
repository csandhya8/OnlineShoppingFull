package com.techm.auth.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class TokenIsValid extends HystrixCommand<String> {
	
	public TokenIsValid(){
		super(HystrixCommandGroupKey.Factory.asKey("TokenIsValid Auth Service"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("TokenIsValid Auth Service");
	        return "TokenIsValid Auth Service";
	    }

}
