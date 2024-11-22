package com.bbar.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbar.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
}
