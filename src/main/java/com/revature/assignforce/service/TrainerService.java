package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Trainer;

public interface TrainerService {
	
	List<Trainer> getAll();
	Optional<Trainer> findById(int id);
	Trainer update(Trainer t);
	Trainer create(Trainer t);
	void delete(int id);
	Optional<Trainer> findByEmail(String email);
}
