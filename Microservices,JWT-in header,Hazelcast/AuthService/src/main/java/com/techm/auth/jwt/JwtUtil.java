package com.techm.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class JwtUtil {
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
	    
    public static String generateToken(String signingKey, String username, String password) {
    
    final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
	String customlogger ="ADMS Loger::::";
	LOGGER.info(customlogger+"JwtUtil Started.");
	
       long nowMillis = System.currentTimeMillis();
      // long ttl= 60000;
    	// long exp = nowMillis + ttl ;
    	
		JwtBuilder builder = Jwts.builder()
    		   .setIssuedAt(new Date(nowMillis))
    		   .setSubject(String.valueOf(username))  
       		   .setIssuer(signingKey)
       		   
       		   //.setExpiration(new Date(exp))
       	       .claim("password", password)
       		   .signWith(SignatureAlgorithm.HS256, signingKey);
	
    	
    	 	   return builder.compact();

    }
    
public static String getSubject(HttpServletResponse httpServletResponse,String token, String signingKey) {
		
		LOGGER.info("JWTUtil Service Started::::::");
		LOGGER.info("Inside getSubject() method::::");
		Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
		String username = claims.getBody().getSubject();
		LOGGER.info("Subject :::"+username);
		return username;
		
		
	}

	public static String getPassword(HttpServletResponse httpServletResponse,String token, String signingKey) {
		LOGGER.info("JWTUtil Service Started::::::");
		LOGGER.info("Inside getPassword() method::::");
		Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
		Object password = claims.getBody().get("password");
		LOGGER.info("password :::"+password);
		return password.toString();
	}

}
