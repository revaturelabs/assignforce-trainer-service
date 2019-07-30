package com.revature.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import com.revature.assignforce.repos.CertRepo;
import com.revature.assignforce.service.CertService;
import com.revature.assignforce.service.CertServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CertServiceImplTest {

	@Configuration
	static class CertServiceTestContextConfiguration {
	@Bean
	public CertService certService() {
		return new CertServiceImpl();
		}
	@Bean
	public CertRepo CertRepo() {
		return Mockito.mock(CertRepo.class);
		}
	}
	
	@Autowired
	private CertService certService;
	@Autowired
	private CertRepo certRepository;
	
	
	@Test
	public void getAllTest() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		List<Cert> certList = new ArrayList<Cert>();
		certList.add(c1);
		certList.add(c2);
		certList.add(c3);
		Mockito.when(certRepository.findAll()).thenReturn(certList);
		List<Cert> testList = certService.getAll();
		assertTrue(testList.size() == 3);
	}
	
	@Test
	public void findByIdTest() {
		Cert c1 = new Cert(3, "AWS");
		Optional<Cert> op1 = Optional.ofNullable(c1);
		Mockito.when(certRepository.findById(3)).thenReturn(op1);
		Optional<Cert> opTest = certService.findById(3);
		assertTrue(opTest.get().getId() == 3);
	}
	
	@Test
	public void updateTest() {
		Cert c1 = new Cert(1, "AWS");
		c1.setName("Angular");
		Mockito.when(certRepository.save(c1)).thenReturn(c1);
		Cert cTest = certService.update(c1);
		assertTrue(cTest.getName().equals("Angular"));
	}
	
	@Test
	public void createTest() {
		Cert c1 = new Cert(1, "Hibernate");
		Mockito.when(certRepository.save(c1)).thenReturn(c1);
		Cert cTest = certService.create(c1);
		assertTrue(cTest.getId() == 1 && cTest.getName().equals("Hibernate"));
	}
	
	@Test
	public void deleteTest() {
		Mockito.doNothing().when(certRepository).deleteById(4);
		certService.delete(4);
		Optional<Cert> cTest = certService.findById(4);
		assertFalse(cTest.isPresent());
	}

}
