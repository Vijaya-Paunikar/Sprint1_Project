package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "CloudUser_Info")
public class CloudUser 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String serviceVendor;
	
	@Column(unique = true)
	private long phoneNumber;
	
	@Column
	private String userStatus;

	public CloudUser() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CloudUser(String name, String serviceVendor, long phoneNumber, String userStatus) 
	{
		super();
		this.name = name;
		this.serviceVendor = serviceVendor;
		this.phoneNumber = phoneNumber;
		this.userStatus = userStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceVendor() {
		return serviceVendor;
	}

	public void setServiceVendor(String serviceVendor) {
		this.serviceVendor = serviceVendor;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

} 