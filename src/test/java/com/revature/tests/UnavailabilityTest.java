package com.revature.tests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.Unavailability;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UnavailabilityTest {

	@Configuration
	static class UnavailabilityTestContextConfiguration {
		@Bean
		public Unavailability Unavailability() {
			return new Unavailability();
		}
	}
	
	@Test
	public void unavailabilityTest1() {
		Unavailability u1 = new Unavailability();
		assertNotNull(u1);
	}
	
	@Test
	public void unavailabilityTest2() {
		Unavailability u1 = new Unavailability(2, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		assertTrue(u1.getId() == 2);
	}
	
	@Test
	public void getSetIdTest() {
		Unavailability u1 = new Unavailability();
		u1.setId(18);
		assertTrue(u1.getId() == 18);
	}
	
	@Test
	public void getSetStartDateTest() {
		Unavailability u1 = new Unavailability();
		u1.setStartDate(new Date(1223L));
		assertTrue(u1.getStartDate().getTime() == 1223L);
	}
	
	@Test
	public void getSetEndDateTest() {
		Unavailability u1 = new Unavailability();
		u1.setEndDate(new Date(4321L));
		assertTrue(u1.getEndDate().getTime() == 4321L);
	}
	
	@Test
	public void getSetDescriptionTest() {
		Unavailability u1 = new Unavailability();
		u1.setDescription("Doctor appointment");
		assertTrue(u1.getDescription().equals("Doctor appointment"));
	}

}
