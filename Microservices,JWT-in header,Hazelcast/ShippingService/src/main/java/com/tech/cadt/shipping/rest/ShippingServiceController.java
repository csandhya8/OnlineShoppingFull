package com.tech.cadt.shipping.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.cadt.entity.Shipping;
import com.tech.cadt.hystrixdashboard.CreateShippingService;
import com.tech.cadt.hystrixdashboard.GetShippingStatus;
import com.tech.cadt.repository.ShippingRepository;

@RestController
@RequestMapping("/shipping")
public class ShippingServiceController {
	
	@Autowired
	ShippingRepository shippingRepository;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	
	public Shipping createShipping(@RequestBody Shipping shipping,HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers,HttpServletRequest httpServletRequest) {
		CreateShippingService createShippingService = new CreateShippingService();
		createShippingService.execute();
		 ArrayList<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		  System.out.println("value of requested header strlist = "+strlist.get(0).toString());
		  String str = strlist.get(0).toString();
		 
		  System.out.println("value of requested header strarray = "+str);
			RestTemplate restTemplate = new RestTemplate();	
			boolean res = restTemplate.postForObject("http://localhost:9090/jwt-service/loginService/isValid", str, Boolean.class);
			System.out.println("value of res= "+res);
		        
		
			
			if(res){
		shipping = shippingRepository.save(shipping);
		}
	    return shipping;
	}
	
	
	@RequestMapping("/getShippingStatus")

	public Shipping getShippingStatus(@RequestParam long orderId,HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers,HttpServletRequest httpServletRequest) {
		
		GetShippingStatus getShippingStatus = new GetShippingStatus();
		getShippingStatus.execute();
		System.out.print("inside get");
		
		Shipping shipping=null;
		 ArrayList<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		  System.out.println("value of requested header strlist = "+strlist.get(0).toString());
		  String str = strlist.get(0).toString();
		 
		  System.out.println("value of requested header strarray = "+str);
			RestTemplate restTemplate = new RestTemplate();	
			boolean res = restTemplate.postForObject("http://localhost:9090/jwt-service/loginService/isValid", str, Boolean.class);
			System.out.println("value of res= "+res);
		        
		
			
			if(res){
		shipping = shippingRepository.findByOrderId(orderId);
		}
	    return shipping;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ShippingServiceController.class);
    private static final String signingKey = "signingKey";
	
	
		
	}