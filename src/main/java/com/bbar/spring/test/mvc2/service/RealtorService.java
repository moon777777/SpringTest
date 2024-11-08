package com.bbar.spring.test.mvc2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.mvc2.domain.Realtor;
import com.bbar.spring.test.mvc2.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtorByObject(Realtor realtor) {
		
		int count = realtorRepository.insertRealtorByObject(realtor);
		
		return count;
	}
}
