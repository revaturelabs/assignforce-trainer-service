package com.revature.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.SkillMessage;

//import com.revature.assignforce.beans.SkillIdHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSkillMessage {
	
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
		s1.setContext("hello");
		assertTrue(s1.getContext().equals("hello"));
	}
	
	@Test
	public void skillIdMessage3() {
		SkillMessage s1 = new SkillMessage();
		s1.setId(30);
		assertEquals(s1.getId() , (30));
	}
	
	

}
