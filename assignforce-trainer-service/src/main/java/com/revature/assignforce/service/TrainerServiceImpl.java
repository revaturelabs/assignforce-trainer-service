package com.revature.assignforce.service;

import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.repos.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//import com.revature.assignforce.commands.FindLocationCommand;
//import com.revature.assignforce.commands.FindSkillsCommand;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepo trainerRepo;

//	@Autowired
//	private SkillRepository skillRepo;
	
//	@Autowired
//	private FindLocationCommand findLocationCommand;
//
//	@Autowired
//	private FindSkillsCommand findSkillsCommand;

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
		
		// t = validateReferences(t);
		return trainerRepo.save(t);
	}

	@Override
	public Trainer create(Trainer t) {
		Set<SkillIdHolder> skills = t.getSkills();
		if (skills == null) {
			skills = new HashSet<>();
			t.setSkills(skills);
		}
//		t = validateReferences(t);

// 		for (SkillIdHolder s : skills) {
// 			skillRepo.save(s);
// 		}
		return trainerRepo.save(t);
	}

	@Override
	public void delete(int id) {
		Optional<Trainer> t = trainerRepo.findById(id);
		if (!t.isPresent()) {
			return;
		}
		t.get().setSkills(new HashSet<>());
		trainerRepo.save(t.get());
		trainerRepo.deleteById(id);
	}
	
	@Override
	public List<Trainer> findByPreferredLocation(Integer preferredLocation) {
		return trainerRepo.findByPreferredLocation(preferredLocation);
	}

	@Override
	public List<Trainer> findBySkills(int skill_id) {
		return trainerRepo.findBySkills(skill_id);
	}

	@Override
	public List<Trainer> findByLastName(String lastName) {
		return trainerRepo.findByLastName(lastName);
	}

	@Override
	public List<Trainer> findByFirstAndLastName(String firstName, String lastName) {
		return trainerRepo.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<Trainer> findByFirstName(String firstName) {
		return trainerRepo.findByFirstName (firstName);
	}

//	private Trainer validateReferences(Trainer trainer) {
//		trainer = findLocationCommand.findLocation(trainer);
//		trainer.setSkills(trainer.getSkills().stream().filter((skillIdHolder) -> findSkillsCommand.findSkill(skillIdHolder)).collect(Collectors.toSet()));
//		return trainer;
//	}
	
}
