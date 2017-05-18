package com.techm.auth.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient
@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
//@EnableZuulProxy
@EnableHystrix
@EnableHystrixDashboard
@EnableAutoConfiguration
@Component
@ComponentScan("com.techm.auth.*")

public class AuthService {

	public static void main(String[] args) {

		SpringApplication.run(AuthService.class, args);
		final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);
		String customlogger ="ADMS Loger::::";
		LOGGER.info(customlogger+"Auth Service Started....");

	}
	

	

}