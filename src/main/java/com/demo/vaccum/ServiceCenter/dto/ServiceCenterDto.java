package com.demo.vaccum.ServiceCenter.dto;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.demo.vaccum.ServiceCenter.model.Address;

import lombok.Data;

@Data
public class ServiceCenterDto {
	private String name;
	private String description;
	private String email;
	private String imgUrl;
	private long mobileNumber;
	private int addressId;
}
