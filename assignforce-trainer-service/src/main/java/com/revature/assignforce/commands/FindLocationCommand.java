//package com.revature.assignforce.commands;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.revature.assignforce.beans.Trainer;
//
//@Component
//public class FindLocationCommand {
//	@Value("${environment.gateway-url:http://localhost:8765/}")
//	private String gatewayUrl;
//	@Value("${environment.service.location:location-service/}")
//	private String locationUri;
//
//	private final RestTemplate restTemplate = new RestTemplate();
//
//	@HystrixCommand(fallbackMethod = "findLocationFallback")
//	public Trainer findLocation(Trainer trainer) {
//		restTemplate.getForEntity(gatewayUrl + locationUri + trainer.getPreferredLocation(), String.class);
//
//		return trainer;
//	}
//
//	public Trainer findLocationFallback(Trainer trainer) {
//		trainer.setPreferredLocation(0);
//		return trainer;
//	}
//
//	public RestTemplate getRestTemplate() {
//		return restTemplate;
//	}
//}
