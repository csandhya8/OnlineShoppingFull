package org.exampledriven.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.net.MalformedURLException;
import java.net.URL;

@EnableZuulProxy
@SpringBootApplication
//@CrossOrigin
public class SpringCloudZuulExampleApplication {

	 @Bean
	 public CorsFilter corsFilter() {
	     final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
	     final CorsConfiguration corsConfig = new CorsConfiguration();
	     corsConfig.setAllowCredentials(true);
	     corsConfig.addAllowedOrigin("*");
	     corsConfig.addAllowedHeader("*");
	     corsConfig.addAllowedMethod("*");
	
	     urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
	     return new CorsFilter(urlBasedCorsConfigurationSource);
	 }
    public static void main(String[] args) throws MalformedURLException {


        SpringApplication.run(SpringCloudZuulExampleApplication.class, args);

    }

}
