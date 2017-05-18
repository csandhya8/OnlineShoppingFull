package com.tech.cadt.hystrixdashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetAllCatalogueService  extends HystrixCommand<String> {
	
	public GetAllCatalogueService(){
		super(HystrixCommandGroupKey.Factory.asKey("GetAll CatalogueService"));
	}
	
	 @Override
	    protected String run() throws Exception {
	       System.out.println("GetAll CatalogueService");
	        return "GetAll CatalogueService";
	    }
}
