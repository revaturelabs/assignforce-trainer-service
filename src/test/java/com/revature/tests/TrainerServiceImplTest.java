package com.revature.tests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.beans.Unavailability;
import com.revature.assignforce.repos.TrainerRepo;
import com.revature.assignforce.service.TrainerService;
import com.revature.assignforce.service.TrainerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrainerServiceImplTest {

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
	}

	@Autowired
	private TrainerService trainerService;
	@Autowired
	private TrainerRepo trainerRepository;

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
		List<Trainer> testList = trainerService.getAll();
		assertTrue(testList.size() == 2);
	}

	@Test
	public void findByIdTest() {
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
		Trainer t1 = new Trainer(1, "Denzel", "Washington", true, 1, unavailabilitySet, "dWashington@gmail.com",
				skillSet, certSet, "I am a Professional", "www.linkedin.com");
		Optional<Trainer> op1 = Optional.ofNullable(t1);
		Mockito.when(trainerRepository.findById(1)).thenReturn(op1);
		Optional<Trainer> opTest = trainerService.findById(1);
		assertTrue(opTest.get().getFirstName().equals("Denzel"));
	}

	@Test
	public void findByEmailTest() {
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
		Optional<Trainer> opTest = trainerService.findByEmail("bWilly@gmail.com");
		assertTrue(opTest.get().getEmail().equals("bWilly@gmail.com"));
	}

	@Test
	public void updateTest() {
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
		t1.setEmail("newBW2018@yahoo.com");
		Mockito.when(trainerRepository.save(t1)).thenReturn(t1);
		Trainer testTrainer = trainerService.update(t1);
		assertTrue(testTrainer.getEmail().equals("newBW2018@yahoo.com"));
	}

	@Test
	public void createTest() {
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
		Trainer testTrainer = trainerService.create(t1);
		assertTrue(testTrainer.getId() == 12);
	}

	@Test
	public void deleteTest() {
		Mockito.doNothing().when(trainerRepository).deleteById(44);
		trainerService.delete(44);
		Optional<Trainer> opTest = trainerService.findById(44);
		assertFalse(opTest.isPresent());
	}

}
