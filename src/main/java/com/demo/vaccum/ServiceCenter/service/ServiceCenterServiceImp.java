package com.demo.vaccum.ServiceCenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vaccum.ServiceCenter.dao.ServiceCenterRepository;
import com.demo.vaccum.ServiceCenter.dto.ServiceCenterDto;
import com.demo.vaccum.ServiceCenter.model.Address;
import com.demo.vaccum.ServiceCenter.model.ServiceCenter;

@Service
public class ServiceCenterServiceImp implements ServiceCenterService{
	@Autowired
	ServiceCenterRepository repository;
	
	@Autowired
	AddressServiceImp service;
	
	@Override
	public ServiceCenter addServiceCenter(ServiceCenterDto serviceCenter) {
		ServiceCenter center = new ServiceCenter();
		center.setDescription(serviceCenter.getDescription());
		center.setEmail(serviceCenter.getEmail());
		center.setMobileNumber(serviceCenter.getMobileNumber());
		center.setImgUrl(serviceCenter.getImgUrl());
		center.setName(serviceCenter.getName());
		Address address = service.findById(serviceCenter.getAddressId());
		center.setAddress(address);
		return repository.save(center);
	}

	@Override
	public ServiceCenter findById(int id) {
		Optional<ServiceCenter> center = repository.findById(id);
		ServiceCenter serviceCenter = new ServiceCenter();
		if(center.isPresent()) {
			serviceCenter = center.get();
		}
		return serviceCenter;
	}

	@Override
	public ServiceCenter updateServiceCenter(ServiceCenterDto serviceCenter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceCenter> searchByField(String field) {
		List<ServiceCenter> centers = new ArrayList<>();
		if(field != null) {
			field = field.toLowerCase();
			for(ServiceCenter center: repository.findAll()) {
				if(center.getAddress().getCity().toLowerCase().contains(field) ||
						center.getAddress().getState().toLowerCase().contains(field) ||
						center.getAddress().getLandMark().toLowerCase().contains(field)) {
					centers.add(center);
				}
			}
		}
		
		return centers;
	}

	@Override
	public List<ServiceCenter> showAllServiceCenters() {
		return repository.findAll();
	}

	@Override
	public String deleteServiceCenter(int id) {
		Optional<ServiceCenter> center = repository.findById(id);
		ServiceCenter serviceCenter = new ServiceCenter();
		if(center.isPresent()) {
			repository.deleteById(id);
			return "Service center deleted successfully";
		}
		return "Service center deleted failed";
	}

	@Override
	public List<ServiceCenter> findByMultipleIds(List<Integer> ids) {
		List<ServiceCenter> center = new ArrayList<>();
		for(Integer id : ids) {
			center.add(findById(id));
		}
		return center;
	}
	
	

}
