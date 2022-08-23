package com.demo.vaccum.ServiceCenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vaccum.ServiceCenter.dao.AddressRepository;
import com.demo.vaccum.ServiceCenter.model.Address;

@Service
public class AddressServiceImp implements AddressService{
	@Autowired
	AddressRepository repository;
	
	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return repository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAddress(int id) {
		Optional<Address> address = repository.findById(id);
		if(address.isPresent()) {
			repository.deleteById(id);
			return "Address deleted successfully";
		}
		return "Address deleted failed";
	}

	@Override
	public Address findById(int id) {
		Optional<Address> address = repository.findById(id);
		if(address.isPresent()) {
			return address.get();
		}
		return null;
	}

}
