package com.example.repository;

import com.example.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    // You can add custom queries if needed
}