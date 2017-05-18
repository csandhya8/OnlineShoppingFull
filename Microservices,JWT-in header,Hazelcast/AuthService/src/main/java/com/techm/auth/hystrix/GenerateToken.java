package com.techm.auth.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GenerateToken extends HystrixCommand<String> {
	
	public GenerateToken(){
		super(HystrixCommandGroupKey.Factory.asKey("Generate Token Auth Service"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Generate Token Auth Service");
	        return "Generate Token Auth Service";
	    }

}
