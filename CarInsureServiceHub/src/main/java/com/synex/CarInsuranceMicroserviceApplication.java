package com.synex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.synex.domain")

public class CarInsuranceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarInsuranceMicroserviceApplication.class, args);
	}

}
