//package com.revature.assignforce.commands;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.revature.assignforce.beans.SkillIdHolder;
//
//@Component
//public class FindSkillsCommand {
//	@Value("${environment.gateway-url:http://localhost:8765/}")
//	private String gatewayUrl;
//	@Value("${environment.service.skills:skill-service/}")
//	private String skillUri;
//
//	private final RestTemplate restTemplate = new RestTemplate();
//
//	@HystrixCommand(fallbackMethod = "findSkillFallback")
//	public boolean findSkill(SkillIdHolder skillIdHolder) {
//		restTemplate.getForEntity(gatewayUrl + skillUri + skillIdHolder.getId(), String.class);
//		return true;
//	}
//
//	public boolean findSkillFallback(SkillIdHolder skillIdHolder) {
//		return false;
//	}
//
//	public RestTemplate getRestTemplate() {
//		return restTemplate;
//	}
//}
