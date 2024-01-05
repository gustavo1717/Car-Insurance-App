package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Claim;
import com.synex.domain.Policy;


public interface ClaimRepository extends JpaRepository<Claim, Long>{
	List<Claim> findByUsername(String username);

}
