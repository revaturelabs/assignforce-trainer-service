package com.revature.assignforce.beans;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
