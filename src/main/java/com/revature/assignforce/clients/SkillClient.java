package com.revature.assignforce.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.assignforce.beans.Skill;

@FeignClient(name = "skill-service/skill/", fallback = SkillClientFallback.class)
public interface SkillClient {

	@GetMapping("/{id}")
	public Skill getSkill(int id);
}
