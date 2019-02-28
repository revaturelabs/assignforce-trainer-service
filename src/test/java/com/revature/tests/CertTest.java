package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.Cert;

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
	
	@Test
	public void fullTest1(){
		int id1 = 5928;
		int id2 = 1102;
		String certName1 = "Unity";
		String certName2 = "C#";
		Cert c1 = new Cert(id1, certName1);
		Cert c2 = new Cert();
		c2.setCertName(certName2);
		c2.setCertId(id2);
		assertEquals(certName2, c2.getCertName());
		assertEquals(certName1, c1.getCertName());
		assertEquals(id1, c1.getCertId());
		assertEquals(id2, c2.getCertId());
	}

	@Test
	public void fullTest2(){
		int id1 = 9519;
		int id2 = 33154;
		int id3 = 118579;
		String certName1 = "Perl";
		String certName2 = "GameMakerX";
		String certName3 = "Godot";
		Cert c1 = new Cert(id1, certName1);
		Cert c2 = new Cert();
		Cert c3 = new Cert(id3, certName2);
		c2.setCertId(id2);
		c2.setCertName(certName3);
		assertEquals(certName3, c2.getCertName());
		assertEquals(id1, c1.getCertId());
		assertEquals(id3, c3.getCertId());
		assertEquals(id2, c2.getCertId());
		assertEquals(certName2, c3.getCertName());
		assertEquals(certName1, c1.getCertName());
	}

}
