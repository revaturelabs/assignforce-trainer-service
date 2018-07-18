package com.revature.assignforce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.assignforce.beans.Cert;

@Repository
public interface CertRepo extends JpaRepository<Cert, Integer>{

}
