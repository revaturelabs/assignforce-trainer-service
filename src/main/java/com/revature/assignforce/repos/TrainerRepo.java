package com.revature.assignforce.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.assignforce.beans.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer>{

	Optional<Trainer> findByEmail(String email);

}
