package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CreateCatalogueService extends HystrixCommand<String> {
	
	public CreateCatalogueService(){
		super(HystrixCommandGroupKey.Factory.asKey("Create CatalogueService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Create CatalogueService");
	        return "Create CatalogueService";
	    }
}
