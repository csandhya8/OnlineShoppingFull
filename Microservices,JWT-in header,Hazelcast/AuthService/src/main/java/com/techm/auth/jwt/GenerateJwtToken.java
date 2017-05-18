package com.techm.auth.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;





@RestController
@RequestMapping(value="/loginService")
@Component

public class GenerateJwtToken {		
	
	 private static final String signingKey = "my-jwt-secret-token";
	    
	  //  String token = null ;
	    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateJwtToken.class);
	    String customlogger ="ADMS Loger::::";
	
	

@RequestMapping(value= "/isValid",method = RequestMethod.POST, produces = "application/json")	


public static boolean validateJWT( @RequestBody String compactJws,HttpServletResponse httpServletResponse ) {
	 System.out.println("validateJWT Started:::::");
	 //String compactJws = compactJws1.toString();
	 System.out.println("value of compactJws= "+compactJws);
	 boolean isValid = false;
	 String secretkey = "my-jwt-secret-token";
    try {
        Jwts.parser().setSigningKey(secretkey).parseClaimsJws(compactJws);
        isValid = true;
        Claims claims = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(compactJws).getBody();
        System.out.println("claims.getSubject():::"+claims.getSubject());
        System.out.println("value of isValid= "+isValid);
    } catch (SignatureException e) {
           System.out.println("Exception :::"+e);
    }
    return isValid;
}
    
    @RequestMapping(value="/test")
    public String test(){
    	return "success";
    }

    
    
   

    
    
	@RequestMapping(value="/generateToken",method = RequestMethod.POST, produces = "application/json")	

	public String generateToken(HttpServletResponse httpServletResponse,@RequestBody String userCredentials,HttpServletRequest httpServletRequest) {
		String token =null;
       
		LOGGER.info(customlogger+"GenerateJwtToken Started");
		LOGGER.info(customlogger+"Loggedin User Credentials ::" + userCredentials);
		JSONObject userCredjson = null;
		String username = null;
		String password = null;
		try {
			if (userCredentials != null)
				userCredjson = new JSONObject(userCredentials.toString());
			if (userCredjson != null) {
				username = userCredjson.optString("userName");
				System.out.println("username------"+username);
				System.out.println("username--aaa----"+userCredjson);
				password = userCredjson.optString("password");
				LOGGER.info(customlogger+"Entered username ::"+username+"\t Entered password ::"+password);
				
				
				
				
				RestTemplate restTemplate = new RestTemplate();	
				String res = restTemplate.postForObject("http://172.18.32.167:9090/customer-service/customer/getCustomer", userCredentials, String.class);
				System.out.println("value of res= "+res);
			        
				//String res="success";
				if(res.equals("success")){
				
				 token = JwtUtil.generateToken(signingKey, username,password);
				LOGGER.info(customlogger+"Generated JwtToken:::" +token);
				System.out.println("success");
				/*String value = new StringBuilder(ipAddress).append("-").append(username).toString();
				System.out.println(value);
				jwttoken.put(value,token);
				*/
			
		}
				/*else{
					token = null;	
				}*/
				}
		} catch (Exception e) {
			LOGGER.error(customlogger+"Exception Occured in generateToken() method");
			e.printStackTrace();
		}
		
		System.out.println("Yet to return token= "+token);
		
		return token;
	}
	


}
