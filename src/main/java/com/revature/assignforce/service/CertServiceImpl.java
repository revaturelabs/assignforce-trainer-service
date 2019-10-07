package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.repos.CertRepo;

@Service
@Transactional

/*
 * Only a User with an SVP role should have access to these
 * methods
 * 
 */
//@PreAuthorize("hasRole('SVP')")
public class CertServiceImpl implements CertService {

	@Autowired
	private CertRepo certRepo;
	
	@Override
	public List<Cert> getAll() {
		return certRepo.findAll();
	}

	@Override
	public Optional<Cert> findById(int id) {
		return certRepo.findById(id);
	}

	@Override
	public Cert update(Cert c) {
		return certRepo.save(c);
	}

	@Override
	public Cert create(Cert c) {
		return certRepo.save(c);
	}

	@Override
	public void delete(int id) {
		certRepo.deleteById(id);
	}

}
