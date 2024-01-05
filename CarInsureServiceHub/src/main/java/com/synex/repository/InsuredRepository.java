package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Insured;

public interface InsuredRepository extends JpaRepository <Insured, Long>{

}
