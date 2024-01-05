package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

	List<Policy> findByUsername(String user);
		
}
