package com.demo.vaccum.ServiceCenter.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.vaccum.ServiceCenter.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
	Optional<Address> findById(int id);
}
