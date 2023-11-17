package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CloudVendor;

public interface VendorRepository extends JpaRepository<CloudVendor, Long>
{
	boolean existsByPhoneNumber(long phoneNumber);
}
