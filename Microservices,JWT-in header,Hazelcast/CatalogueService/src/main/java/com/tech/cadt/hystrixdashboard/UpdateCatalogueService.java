package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class UpdateCatalogueService extends HystrixCommand<String> {
	
	public UpdateCatalogueService(){
		super(HystrixCommandGroupKey.Factory.asKey("Update CatalogueService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("Update CatalogueService");
	        return "Update CatalogueService";
	    }
}
