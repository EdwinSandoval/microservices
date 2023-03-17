package com.example.serviceplazoleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaServer
@SpringBootApplication
public class ServicePlazoletaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlazoletaApplication.class, args);
			System.out.print("Terminado---------------*******");
		}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
