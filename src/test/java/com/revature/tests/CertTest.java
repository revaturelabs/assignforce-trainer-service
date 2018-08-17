package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.beans.SkillIdHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CertTest {

	@Configuration
	static class CertTestContextConfiguration {
		@Bean
		public Cert Cert() {
			return new Cert();
		}
	}
	
	@Test
	public void certTest1() {
		Cert c1 = new Cert();
		assertNotNull(c1);
	}
	
	@Test
	public void certTest2() {
		Cert c1 = new Cert(3, "Java");
		assertTrue(c1.getCertId() == 3);
	}
	
	@Test
	public void getSetCertIdTest() {
		Cert c1 = new Cert();
		c1.setCertId(49);
		assertTrue(c1.getCertId() == 49);
	}
	
	@Test
	public void getSetCertNameTest() {
		Cert c1 = new Cert();
		c1.setCertName("SQL");
		assertTrue(c1.getCertName().equals("SQL"));
	}

}
