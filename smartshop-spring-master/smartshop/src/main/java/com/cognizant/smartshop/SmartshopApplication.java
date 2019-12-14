package com.cognizant.smartshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartshopApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SmartshopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmartshopApplication.class, args);
		
		LOGGER.info("Inside  Smart shop ServiceApplication main");
	}

}
