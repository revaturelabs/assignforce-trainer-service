package com.revature.assignforce.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.assignforce.repos.SkillRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Entity
@Table(name = "SKILLIDHOLDER")
public class SkillIdHolder {
	
	@Id
	@Column(name="SKILL_ID")
	private int skillId;

	public SkillIdHolder() {
		super();
	}

	public SkillIdHolder(int skillId) {
		super();
		this.skillId = skillId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	
}
