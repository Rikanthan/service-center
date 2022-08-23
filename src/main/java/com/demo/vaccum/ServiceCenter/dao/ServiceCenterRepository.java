package com.demo.vaccum.ServiceCenter.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.vaccum.ServiceCenter.model.Address;
import com.demo.vaccum.ServiceCenter.model.ServiceCenter;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter,Integer>{
	Optional<ServiceCenter> findById(int id);
	Optional<ServiceCenter> findByAddress(Address address);
}
