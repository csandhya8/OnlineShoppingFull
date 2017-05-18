package com.techm.customerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableEurekaClient
@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@ComponentScan("com.techm.customerservice.*")
public class OnlineShoppingCart {

	public static void main(String[] args) {

		SpringApplication.run(OnlineShoppingCart.class, args);
		final Logger LOGGER = LoggerFactory.getLogger(OnlineShoppingCart.class);
		String customlogger ="ADMS Loger::::";
		System.out.println("Online Shopping Cart Service Started....");

	}

}