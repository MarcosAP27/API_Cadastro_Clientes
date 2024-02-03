package com.marcos.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ClienteCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteCadastroApplication.class, args);
	}

}
