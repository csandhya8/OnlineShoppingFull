package com.tech.cadt.catalogue.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.tech.cadt.cache.rest.HazelCastServiceController;









import com.tech.cadt.CatalogueService;
import com.tech.cadt.hystrixdashboard.CreateCatalogueService;
import com.tech.cadt.hystrixdashboard.GetAllCatalogueService;
import com.tech.cadt.hystrixdashboard.UpdateCatalogueService;
import com.tech.cadt.product.entity.Product;
import com.tech.cadt.product.repository.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/catalogueService")
@Component

public class CatalogueServiceController extends SpringBootServletInitializer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogueServiceController.class);
	String customlogger ="ADMS Loger::::";
	
	
	
    private static final String signingKey = "signingKey";
	
    @Autowired 
	ProductRepository productRepository;
	


	@RequestMapping(value="/create",method = RequestMethod.POST, produces = "application/json")	

	public Product create(@Valid @RequestBody Product product) {
		
		CreateCatalogueService createCatalogueService=new CreateCatalogueService();
		createCatalogueService.execute();
		
		try{				
			System.out.println("Product"+product.getCost());
			product = productRepository.save(product);	
		System.out.println("Product"+product);
		
	}catch(Exception e){
		System.out.println("Connection Exception"+e.getMessage());
	}
	    return product;
	}
	
	
	@RequestMapping(value = "/update",method = RequestMethod.POST, produces = "application/json")	


	public Product update(@Valid @RequestBody Product product,HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers,HttpServletRequest httpServletRequest) {
		UpdateCatalogueService updateCatalogueService = new UpdateCatalogueService();
		updateCatalogueService.execute();
		Product products=null;
		
		 ArrayList<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		  System.out.println("value of requested header strlist = "+strlist.get(0).toString());
		  String str = strlist.get(0).toString();
		 
		  System.out.println("value of requested header strarray = "+str);
		  
		
		//jwt Token validation
		RestTemplate restTemplate = new RestTemplate();	
		boolean res = restTemplate.postForObject("http://172.18.32.167:9090/jwt-service/loginService/isValid", str, Boolean.class);
		System.out.println("value of res= "+res);
	        
	
		
		if(res){
			products= productRepository.findById(product.getId());
		
		products.setAvailableitems(product.getAvailableitems());
		
		products = productRepository.save(products);		
		}
	    return products;
	}
	
	
	@RequestMapping("/read-all")
	public  List<Product> readAll(HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers,HttpServletRequest httpServletRequest) throws InterruptedException {
		  System.out.println("inside read all of catalogue ");
		List<Product> product =null;
		GetAllCatalogueService getAllCatalogueService = new GetAllCatalogueService();
		getAllCatalogueService.execute();
		
		 ArrayList<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		  System.out.println("value of requested header strlist = "+strlist.get(0).toString());
		  String str = strlist.get(0).toString();
		 
		  System.out.println("value of requested header strarray = "+str);
		  
		
		//jwt Token validation
		RestTemplate restTemplate = new RestTemplate();	
		boolean res = restTemplate.postForObject("http://172.18.32.167:9090/jwt-service/loginService/isValid", str, Boolean.class);
		System.out.println("value of res= "+res);
	        
	
		
		if(res){
			System.out.println("inside if validToken");
			product= productRepository.findAll();	
			System.out.println("Product value= "+product);
		}
		 return product;
		
		}
	
	
	

}
