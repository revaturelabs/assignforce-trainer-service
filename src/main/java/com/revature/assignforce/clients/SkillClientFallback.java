package com.revature.assignforce.clients;

import org.springframework.stereotype.Component;

import com.revature.assignforce.beans.Skill;

@Component
public class SkillClientFallback implements SkillClient {

	@Override
	public Skill getSkill(int id) {
		return new Skill();
	}

}
