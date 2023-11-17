package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CloudUser;

public interface UserRepository extends JpaRepository<CloudUser, Long>
{

	boolean existsByPhoneNumber(long phoneNumber);

	boolean existsByPhoneNumberAndIdNot(long phoneNumber, long id);

}
