package com.revature.assignforce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.assignforce.beans.SkillIdHolder;

@Repository
@Transactional
public interface SkillRepository extends JpaRepository<SkillIdHolder, Integer> {

}
