package com.revature.tests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.beans.Unavailability;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrainerTest {
	
	@Configuration
	static class CertServiceTestContextConfiguration {
	@Bean
	public Trainer Trainer() {
		return new Trainer();
		}
	}

	
	@Test
	public void trainerTest1() {
		Trainer t1 = new Trainer();
		assertNotNull(t1);
	}
	
	@Test
	public void trainerTest2() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(192933L), new Date(30L), "Family matter");
		Unavailability u2 = new Unavailability(1, new Date(10000L), new Date(20000L), "Medical check up");
		SkillIdHolder s1 = new SkillIdHolder(7);
		SkillIdHolder s2 = new SkillIdHolder(8);
		SkillIdHolder s3 = new SkillIdHolder(10);
		HashSet<Cert> certSet = new HashSet<Cert>();
		certSet.add(c1);
		certSet.add(c2);
		certSet.add(c3);
		HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
		unavailabilitySet.add(u1);
		unavailabilitySet.add(u2);
		HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
		skillSet.add(s1);
		skillSet.add(s2);
		skillSet.add(s3);
		Trainer t1 = new Trainer(1, "Denzel", "Washington", true, 1, unavailabilitySet, 
				"dWashington@gmail.com", skillSet, certSet, "I am a Professional", "www.linkedin.com");
		assertTrue(t1.getId() == 1);
	}
	
	@Test
	public void getSetIdTest() {
		Trainer t1 = new Trainer();
		t1.setId(7);
		assertTrue(t1.getId() == 7);
	}
	
	@Test
	public void getSetFirstNameTest() {
		Trainer t1 = new Trainer();
		t1.setFirstName("John");
		assertTrue(t1.getFirstName().equals("John"));
	}
	
	@Test
	public void getSetLastNameTest() {
		Trainer t1 = new Trainer();
		t1.setLastName("Cena");
		assertTrue(t1.getLastName().equals("Cena"));
	}

	@Test
	public void getSetIsActiveTest() {
		Trainer t1 = new Trainer();
		t1.setIsActive(true);
		assertTrue(t1.getIsActive());
	}
	
	@Test
	public void getSetPreferredLocationTest() {
		Trainer t1 = new Trainer();
		t1.setPreferredLocation(new Integer(4));
		assertTrue(t1.getPreferredLocation() == 4);
	}
	
	@Test
	public void getSetUnavailabilityTest() {
		Unavailability u1 = new Unavailability(1, new Date(11111L), new Date(22222L), "Family matter");
		Unavailability u2 = new Unavailability(1, new Date(44444L), new Date(943293L), "Medical check up");
		HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
		unavailabilitySet.add(u1);
		unavailabilitySet.add(u2);
		Trainer t1 = new Trainer();
		t1.setUnavailabilities(unavailabilitySet);
		assertTrue(t1.getUnavailabilities().size() == 2);
	}
	
	@Test
	public void getSetEmailTest() {
		Trainer t1 = new Trainer();
		t1.setEmail("cantSeeMe321@gmail.com");
		assertTrue(t1.getEmail().equals("cantSeeMe321@gmail.com"));
	}
	
	@Test
	public void getSetSkills() {
		SkillIdHolder s1 = new SkillIdHolder(7);
		SkillIdHolder s2 = new SkillIdHolder(8);
		SkillIdHolder s3 = new SkillIdHolder(10);
		HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
		skillSet.add(s1);
		skillSet.add(s2);
		skillSet.add(s3);
		Trainer t1 = new Trainer();
		t1.setSkills(skillSet);
		assertTrue(t1.getSkills().size() == 3);
	}
	
	@Test
	public void getSetSkills2() {
		SkillIdHolder s1 = new SkillIdHolder(7);
		SkillIdHolder s2 = new SkillIdHolder(8);
		SkillIdHolder s3 = new SkillIdHolder(10);
		SkillIdHolder s4 = new SkillIdHolder(12);
		HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
		skillSet.add(s1);
		skillSet.add(s2);
		skillSet.add(s3);
		Trainer t1 = new Trainer();
		t1.setSkills(skillSet);
		assertTrue(t1.getSkills().add(s4));
	}
	
	
	@Test
	public void getSetCertificationsTest() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		HashSet<Cert> certSet = new HashSet<Cert>();
		certSet.add(c1);
		certSet.add(c2);
		certSet.add(c3);
		Trainer t1 = new Trainer();
		t1.setCertifications(certSet);
		assertTrue(t1.getCertifications().size() == 3);
	}
	
	@Test
	public void getSetCertificationsTest2() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Cert c4 = new Cert(7, "Angular");
		HashSet<Cert> certSet = new HashSet<Cert>();
		certSet.add(c1);
		certSet.add(c2);
		certSet.add(c3);
		Trainer t1 = new Trainer();
		t1.setCertifications(certSet);
		assertTrue(t1.getCertifications().add(c4));
	}
	
	@Test
	public void getSetResumeTest() {
		Trainer t1 = new Trainer();
		t1.setResume("Im a professional");
		assertTrue(t1.getResume().equals("Im a professional"));
	}
	
	@Test
	public void getSetLinkedInUrlTest() {
		Trainer t1 = new Trainer();
		t1.setLinkedInUrl("someUrl");
		assertTrue(t1.getLinkedInUrl().equals("someUrl"));
	}
	
}
