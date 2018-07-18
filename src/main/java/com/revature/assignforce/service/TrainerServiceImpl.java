package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.repos.TrainerRepo;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepo trainerRepo;
	
	@Override
	public List<Trainer> getAll() {
		return trainerRepo.findAll();
	}

	@Override
	public Optional<Trainer> findById(int id) {
		return trainerRepo.findById(id);
	}
	
	@Override
	public Optional<Trainer> findByEmail(String email) {
		return trainerRepo.findByEmail(email);
	}

	@Override
	public Trainer update(Trainer t) {
		return trainerRepo.save(t);
	}

	@Override
	public Trainer create(Trainer t) {
		return trainerRepo.save(t);
	}

	@Override
	public void delete(int id) {
		trainerRepo.deleteById(id);
	}

	

}
