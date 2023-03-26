package com.pragma.usuarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableFeignClients
@SpringBootApplication
//@EnableEurekaServer
public class UsuarioServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsuarioServiceApplication.class, args);
		System.out.println("hola");
	}

}
