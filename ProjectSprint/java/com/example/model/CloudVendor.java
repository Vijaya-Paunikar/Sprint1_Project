package com.example.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CloudVendor_Info")
public class CloudVendor 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String vendorName;
	
	@Column
	private String description;
	
	@Column(unique = true)
	private long phoneNumber;
	
	@Column
	private String status;

	public CloudVendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CloudVendor(String vendorName, String description, long phoneNumber, String status) {
		super();
		this.vendorName = vendorName;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static void sendRequestToCloudUser(String message) {
		// TODO Auto-generated method stub
		
	}

	
}