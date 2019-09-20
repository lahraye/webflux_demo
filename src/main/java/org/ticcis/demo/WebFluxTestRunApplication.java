package org.ticcis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebFluxTestRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxTestRunApplication.class, args);
		System.out.println("WebFlux application successfully started!!!");
	}

}
