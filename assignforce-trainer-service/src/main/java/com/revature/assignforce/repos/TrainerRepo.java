package com.revature.assignforce.repos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.assignforce.beans.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer>{

	Optional<Trainer> findByEmail(String email);

	List<Trainer> findByPreferredLocation(Integer preferredLocation);

    List<Trainer> findBySkills(int skill_id);

    List<Trainer> findByLastName(String lastName);

    List<Trainer> findByFirstNameAndLastName(String firstName, String lastName);

    List<Trainer> findByFirstName (String firstName);
}
