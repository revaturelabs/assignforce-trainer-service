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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.controllers.CertController;
import com.revature.assignforce.repos.CertRepo;
import com.revature.assignforce.service.CertService;
import com.revature.assignforce.service.CertServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CertControllerTest {

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
	@Bean
	public CertController CertController() {
		return new CertController();
		}
	}
	
	@Autowired
	private CertRepo certRepository;
	@Autowired
	private CertController certController;
	
	@Test
	public void getAllTest() {
		Cert c1 = new Cert(1, "AWS");
		Cert c2 = new Cert(3, "Java");
		Cert c3 = new Cert(5, "SQL");
		Cert c4 = new Cert(7, "JavaScript");
		List<Cert> certList = new ArrayList<Cert>();
		certList.add(c1);
		certList.add(c2);
		certList.add(c3);
		certList.add(c4);
		Mockito.when(certRepository.findAll()).thenReturn(certList);
		List<Cert> testList = certController.getAll();
		assertTrue(testList.size() == 4);
	}
	
	@Test
	public void getByIdTestOk() {
		Cert c1 = new Cert(3, "AWS");
		Optional<Cert> op1 = Optional.ofNullable(c1);
		Mockito.when(certRepository.findById(3)).thenReturn(op1);
		ResponseEntity<Cert> reTest = certController.getById(3);
		assertTrue(reTest.getBody().getId() == 3 && reTest.getStatusCode() == HttpStatus.OK);
	}
	
	@Test
	public void getByIdTestNotFound() {
		ResponseEntity<Cert> reTest = certController.getById(29);
		assertTrue(reTest.getStatusCode() == HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void addTestCreated() {
		Cert c1 = new Cert(18, "Perl");
		Mockito.when(certRepository.save(c1)).thenReturn(c1);
		ResponseEntity<Cert> reTest = certController.add(c1);
		assertTrue(reTest.getBody().getId() == 18 && reTest.getStatusCode() == HttpStatus.CREATED);
	}
	
	@Test
	public void addTestBadRequest() {
		Cert c1 = new Cert(11, "C");
		ResponseEntity<Cert> reTest = certController.add(c1);
		assertTrue(reTest.getStatusCode() == HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void updateTestCreated() {
		Cert c1 = new Cert(18, "Perl");
		c1.setName("C");
		Mockito.when(certRepository.save(c1)).thenReturn(c1);
		ResponseEntity<Cert> reTest = certController.update(c1);
		assertTrue(reTest.getBody().getName().equals("C") && reTest.getStatusCode() == HttpStatus.CREATED);
	}
	
	@Test
	public void updateTestBadRequest() {
		Cert c1 = new Cert(14, "C++");
		c1.setName("D");
		ResponseEntity<Cert> reTest = certController.update(c1);
		assertTrue(reTest.getStatusCode() == HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void deleteTest() {
		Mockito.doNothing().when(certRepository).deleteById(19);
		ResponseEntity<Cert> reTest = certController.delete(19);
		assertTrue(reTest.getStatusCode() == HttpStatus.OK);
	}

}
