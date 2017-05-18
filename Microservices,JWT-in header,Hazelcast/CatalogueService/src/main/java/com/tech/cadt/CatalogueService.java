package com.tech.cadt;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tech.cadt.product.repository.ProductRepository;

@EnableEurekaClient
@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableAutoConfiguration
@Component
@ComponentScan("com.tech.cadt.catalogue.rest")
public class CatalogueService {
	

	
	public static void main(String[] args) {
		SpringApplication.run(CatalogueService.class, args);
		 final Logger LOGGER = LoggerFactory.getLogger(CatalogueService.class);
		   String customlogger ="ADMS Loger::::";
		   LOGGER.info(customlogger+"CustomerService Started");
	}
	
	
}