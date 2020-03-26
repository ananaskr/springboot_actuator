package com.ananskr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WebSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringApplication.class, args);
	}

}
