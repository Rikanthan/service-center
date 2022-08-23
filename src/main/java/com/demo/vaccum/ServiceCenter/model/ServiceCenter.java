package com.demo.vaccum.ServiceCenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_servicecenter")
@Getter
@Setter
public class ServiceCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String email;
	private String imgUrl;
	private String mobileNumber;
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
}
