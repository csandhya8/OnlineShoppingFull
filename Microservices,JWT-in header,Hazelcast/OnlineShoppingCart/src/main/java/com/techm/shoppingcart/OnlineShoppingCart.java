package com.techm.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class OnlineShoppingCart {
/*	 @Bean
	 public CorsFilter corsFilter() {
	     final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
	     final CorsConfiguration corsConfig = new CorsConfiguration();
	     corsConfig.setAllowCredentials(true);
	     corsConfig.addAllowedOrigin("*");
	     corsConfig.addAllowedHeader("*");
	     corsConfig.addAllowedMethod("OPTIONS");
	     corsConfig.addAllowedMethod("HEAD");
	     corsConfig.addAllowedMethod("GET");
	     corsConfig.addAllowedMethod("PUT");
	     corsConfig.addAllowedMethod("POST");
	     corsConfig.addAllowedMethod("DELETE");
	     corsConfig.addAllowedMethod("PATCH");
	     urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
	     return new CorsFilter(urlBasedCorsConfigurationSource);
	 }
*/
	public static void main(String[] args) {

		SpringApplication.run(OnlineShoppingCart.class, args);
		

	}

}