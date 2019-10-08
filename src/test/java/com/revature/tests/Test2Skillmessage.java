package com.revature.tests;


import com.revature.assignforce.SkillMessage;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test2Skillmessage {
	//There're two skillMessage classes.
	//The first one being tested is in com.revature.assignforce.beans
	//The second one is being in com.revature.assignforce	
	//I Ruben Lopez on 10/1/2019 in Alex's batch, going to test the second bean
	
	@Configuration
	static class SkillMessageTestContextConfiguration {
		@Bean
		public SkillMessage SkillMessage() {
			return new SkillMessage();
		}
	}
	
	@Test
	public void skillIdMessage1() {
		SkillMessage s1 = new SkillMessage();
		assertNotNull(s1);
	}
	
	@Test
	public void skillIdMessage2() {
		SkillMessage s1 = new SkillMessage();
		s1.setSkillId(8);
		assertTrue(new Integer(s1.getSkillId()).equals(new Integer(8)));
	}
	
	


}
