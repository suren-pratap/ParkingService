package com.pls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingServiceApplication {
	private static final Logger LOGGER = LogManager.getLogger(ParkingServiceApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingServiceApplication.class, args);
		LOGGER.info("App Started");

		
	}

}
