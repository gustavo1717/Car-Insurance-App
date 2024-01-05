package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
