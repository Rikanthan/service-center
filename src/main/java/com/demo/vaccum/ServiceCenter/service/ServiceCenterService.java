package com.demo.vaccum.ServiceCenter.service;

import java.util.List;

import com.demo.vaccum.ServiceCenter.dto.ServiceCenterDto;
import com.demo.vaccum.ServiceCenter.model.ServiceCenter;

public interface ServiceCenterService {
	ServiceCenter addServiceCenter(ServiceCenterDto serviceCenter);
	
	ServiceCenter findById(int id);
	
	ServiceCenter updateServiceCenter(ServiceCenterDto serviceCenter);
	
	List<ServiceCenter> searchByField(String field);
	
	List<ServiceCenter> showAllServiceCenters();
	
	String deleteServiceCenter(int id);
	
	List<ServiceCenter> findByMultipleIds(List<Integer> id);
}
