package com.demo.vaccum.ServiceCenter.service;

import com.demo.vaccum.ServiceCenter.model.Address;

public interface AddressService {
	Address addAddress(Address address);
	
	Address updateAddress(Address address);
	
	String deleteAddress(int id);
	
	Address findById(int id);
}
