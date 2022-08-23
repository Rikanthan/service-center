package com.demo.vaccum.ServiceCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vaccum.ServiceCenter.model.Address;
import com.demo.vaccum.ServiceCenter.service.AddressServiceImp;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
	@Autowired
	AddressServiceImp service;
	
	@PostMapping
	public Address address(@RequestBody Address address) {
		return service.addAddress(address);
	}
	@GetMapping
	public Address findById(@RequestParam int id) {
		return service.findById(id);
	}
	@PutMapping
	public Address updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}
	@DeleteMapping
	public String deleteAddress(@RequestParam int id) {
		return service.deleteAddress(id);
	}
}
