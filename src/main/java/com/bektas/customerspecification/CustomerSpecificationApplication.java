package com.bektas.customerspecification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CustomerSpecificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSpecificationApplication.class, args);
	}

}
