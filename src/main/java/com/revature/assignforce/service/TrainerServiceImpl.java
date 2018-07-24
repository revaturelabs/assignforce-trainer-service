package com.revature.assignforce.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.repos.SkillRepository;
import com.revature.assignforce.repos.TrainerRepo;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepo trainerRepo;

	@Autowired
	private SkillRepository skillRepo;

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
		Set<SkillIdHolder> skills = t.getSkills();
		if (skills == null) {
			skills = new HashSet<SkillIdHolder>();
		}

		for (SkillIdHolder s : skills) {
			skillRepo.save(s);
		}
		return trainerRepo.save(t);
	}

	@Override
	public Trainer create(Trainer t) {
		Set<SkillIdHolder> skills = t.getSkills();
		if (skills == null) {
			skills = new HashSet<SkillIdHolder>();
		}

		for (SkillIdHolder s : skills) {
			skillRepo.save(s);
		}
		return trainerRepo.save(t);
	}

	@Override
	public void delete(int id) {
		Optional<Trainer> t = trainerRepo.findById(id);
		if (!t.isPresent()) {
			return;
		}
		t.get().setSkills(new HashSet<SkillIdHolder>());
		trainerRepo.save(t.get());
		trainerRepo.deleteById(id);
	}

}
