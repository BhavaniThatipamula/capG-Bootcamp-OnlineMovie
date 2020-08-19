package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer

@SpringBootApplication
public class EurekaOnlinemovieticketsystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaOnlinemovieticketsystemServerApplication.class, args);
	}
}
