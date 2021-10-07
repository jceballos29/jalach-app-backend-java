package com.jalach.jalach.services;

import com.jalach.jalach.models.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyService extends JpaRepository<Company, Integer> {
    
}
