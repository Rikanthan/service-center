package com.demo.vaccum.ServiceCenter.controller;

import java.util.List;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vaccum.ServiceCenter.dto.ServiceCenterDto;
import com.demo.vaccum.ServiceCenter.model.ServiceCenter;
import com.demo.vaccum.ServiceCenter.service.ServiceCenterServiceImp;

@RestController
@RequestMapping(value = "/servicecenter")
public class ServiceCenterController {
	@Autowired
	ServiceCenterServiceImp service;
	@PostMapping
	public ServiceCenter addServiceCenter(@RequestBody ServiceCenterDto center) {
		return service.addServiceCenter(center);
	}
	
	@GetMapping
	public List<ServiceCenter> showAllServiceCenter(){
		return service.showAllServiceCenters();
	}
	
	@GetMapping(value = "/searchbyfield")
	public List<ServiceCenter> searchServiceCenterByfield(@RequestParam String field){
		return service.searchByField(field);
	}
	
	@GetMapping(value = "/searchByid")
	public ServiceCenter findServiceCenterById(@RequestParam int id) {
		return service.findById(id);
	}
	
	@PutMapping
	public ServiceCenter updateServiceCenter(@RequestBody ServiceCenterDto center) {
		return service.updateServiceCenter(center);
	}
	
	@DeleteMapping
	public String deleteServiceCenter(@RequestParam int id) {
		return service.deleteServiceCenter(id);
	}
	@GetMapping(value ="/findByMultipleId")
	public List<ServiceCenter> findByMultipleId(@RequestParam List<Integer> id){
		return service.findByMultipleIds(id);
	}
}
