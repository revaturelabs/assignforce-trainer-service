package com.revature.assignforce;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableWebSecurity
@EnableSqs
public class AssignForceTrainerServiceApplication {
	
	
	
	private static SpringApplicationBuilder hello = new SpringApplicationBuilder(AssignForceTrainerServiceApplication.class);

	public static void main(String[] args) {
		//new SpringApplicationBuilder(AssignForceTrainerServiceApplication.class).run(args);
		
		hello.run(args);
	}
	
	public static void setLauncher(SpringApplicationBuilder hello) {
		//This method is for testing purposes only
		//Used to verify if the main method runs
		//Could be used to update Spring ApplicationBuilder in real time
		AssignForceTrainerServiceApplication.hello = hello;
	}
	
}
