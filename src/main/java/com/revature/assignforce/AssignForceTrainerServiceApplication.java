package com.revature.assignforce;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AssignForceTrainerServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AssignForceTrainerServiceApplication.class).run(args);
	}
}
