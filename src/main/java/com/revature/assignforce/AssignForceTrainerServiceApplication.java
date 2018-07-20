package com.revature.assignforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AssignForceTrainerServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AssignForceTrainerServiceApplication.class).run(args);

//		SpringApplication.run(AssignForceTrainerServiceApplication.class, args);
	}
}
