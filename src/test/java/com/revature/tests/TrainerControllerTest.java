package com.revature.tests;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.beans.Unavailability;
import com.revature.assignforce.controllers.TrainerController;
import com.revature.assignforce.repos.SkillRepository;
import com.revature.assignforce.repos.TrainerRepo;
import com.revature.assignforce.service.TrainerService;
import com.revature.assignforce.service.TrainerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

//import com.revature.assignforce.commands.FindLocationCommand;
//import com.revature.assignforce.commands.FindSkillsCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrainerControllerTest {

	@Configuration
	static class TrainerServiceTestContextConfiguration {
		@Bean
		public TrainerService TrainerService() {
			return new TrainerServiceImpl();
		}

		@Bean
		public TrainerRepo TrainerRepo() {
			return Mockito.mock(TrainerRepo.class);
		}

		@Bean
		public SkillRepository SkillRepository() {
			return Mockito.mock(SkillRepository.class);
		}

		@Bean
		public TrainerController TrainerController() {
			return new TrainerController();
		}

//		@Bean
//		public FindLocationCommand FindLocationCommand(){
//			return Mockito.mock(FindLocationCommand.class);
//		}
//		@Bean
//		public FindSkillsCommand FindSkillsCommand(){
//			return Mockito.mock(FindSkillsCommand.class);
//		}

	}

	@Autowired
	private TrainerRepo trainerRepository;
	@Autowired
	private TrainerController trainerController;
//	@Autowired
//	private FindLocationCommand findLocationCommand;

	@Test
	public void getAllTest() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(1, "John", "Wick", false, 2, unavailabilitySet, "jWick123@gmail.com", skillSet,
				certSet, "I am a Software Developer", "www.linkedin.com");
		Trainer t2 = new Trainer(2, "James", "Avery", true, 4, unavailabilitySet, "jAvery@yahoo.com", skillSet, certSet,
				"I am a Lawyer", "www.linkedin.com");
		List<Trainer> trainerList = new ArrayList<Trainer>();
		trainerList.add(t1);
		trainerList.add(t2);
		Mockito.when(trainerRepository.findAll()).thenReturn(trainerList);
		List<Trainer> testList = trainerController.getAll();
		assertTrue(testList.size() == 2);
	}

	@Test
	public void getByIdTestOk() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(5, "John", "Wick", false, 2, unavailabilitySet, "jWick123@gmail.com", skillSet,
				certSet, "I am a Software Developer", "www.linkedin.com");
		Optional<Trainer> op1 = Optional.ofNullable(t1);
		Mockito.when(trainerRepository.findById(5)).thenReturn(op1);
		ResponseEntity<Trainer> reTest = trainerController.getById(5);
		assertTrue(reTest.getBody().getId() == 5 && reTest.getStatusCode() == HttpStatus.OK);
	}

	@Test
	public void getByIdTestNotFound() {
		ResponseEntity<Trainer> reTest = trainerController.getById(12);
		assertTrue(reTest.getStatusCode() == HttpStatus.NOT_FOUND);
	}

	@Test
	public void getByEmailTestOk() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(1, "Bernie", "Williams", true, 1, unavailabilitySet, "bWilly@gmail.com", skillSet,
				certSet, "I am a Professional", "www.linkedin.com");
		Optional<Trainer> op1 = Optional.ofNullable(t1);
		Mockito.when(trainerRepository.findByEmail("bWilly@gmail.com")).thenReturn(op1);
		ResponseEntity<Trainer> reTest = trainerController.getByEmail("bWilly@gmail.com");
		assertTrue(reTest.getBody().getId() == 1 && reTest.getStatusCode() == HttpStatus.OK);
	}

	@Test
	public void getByEmailTestNotFound() {
		ResponseEntity<Trainer> reTest = trainerController.getByEmail("someName@yahoo.com");
		assertTrue(reTest.getStatusCode() == HttpStatus.NOT_FOUND);
	}

	@Test
	public void addTestCreated() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(12, "Joey", "Wheeler", true, 31, unavailabilitySet, "monsta14@gmail.com", skillSet,
				certSet, "I am a Duelist", "www.linkedin.com");
		Mockito.when(trainerRepository.save(t1)).thenReturn(t1);
//		Mockito.when(findLocationCommand.findLocation(t1)).thenReturn(t1);

		ResponseEntity<Trainer> reTest = trainerController.add(t1);
		assertTrue(reTest.getBody().getId() == 12 && reTest.getStatusCode() == HttpStatus.CREATED);
	}

	@Test
	public void addTestBadRequest() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(19, "Mickey", "Mouse", true, 31, unavailabilitySet, "monsta14@gmail.com", skillSet,
				certSet, "I am a mouse", "www.linkedin.com");
//		Mockito.when(findLocationCommand.findLocation(t1)).thenReturn(t1);

		ResponseEntity<Trainer> reTest = trainerController.add(t1);
		assertTrue(reTest.getStatusCode() == HttpStatus.BAD_REQUEST);
	}

	@Test
	public void updateTestCreated() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(12, "Joey", "Wheeler", true, 31, unavailabilitySet, "monsta14@gmail.com", skillSet,
				certSet, "I am a Duelist", "www.linkedin.com");
		t1.setEmail("duelistKing@gmail.com");
		Mockito.when(trainerRepository.save(t1)).thenReturn(t1);
//		Mockito.when(findLocationCommand.findLocation(t1)).thenReturn(t1);

		ResponseEntity<Trainer> reTest = trainerController.update(t1);
		assertTrue(reTest.getBody().getEmail().equals("duelistKing@gmail.com")
				&& reTest.getStatusCode() == HttpStatus.CREATED);
	}

	@Test
	public void updateTestBadRequest() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Unavailability u1 = new Unavailability(1, new Date(1460865600000L), new Date(1466395200000L),
				"Family matter");
		Unavailability u2 = new Unavailability(1, new Date(1489982400000L), new Date(1526356800000L),
				"Medical check up");
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
		Trainer t1 = new Trainer(29, "Rick", "Grimes", true, 31, unavailabilitySet, "monsta14@gmail.com", skillSet,
				certSet, "I am a Duelist", "www.linkedin.com");
		t1.setEmail("coral@gmail.com");
//		Mockito.when(findLocationCommand.findLocation(t1)).thenReturn(t1);

		ResponseEntity<Trainer> reTest = trainerController.update(t1);
		assertTrue(reTest.getStatusCode() == HttpStatus.BAD_REQUEST);
	}

	@Test
	public void deleteTestNotFound() {
		Mockito.when(trainerController.delete(0)).thenReturn(null);
		ResponseEntity<Trainer> reTest = trainerController.delete(0);
		assertTrue(reTest.getStatusCode() == HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void deleteTestOk() {
		Mockito.doNothing().when(trainerRepository).deleteById(89);
		ResponseEntity<Trainer> reTest = trainerController.delete(89);
		assertTrue(reTest.getStatusCode() == HttpStatus.OK);
	}
	
}
