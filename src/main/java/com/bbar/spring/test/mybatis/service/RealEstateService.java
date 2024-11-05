package com.bbar.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.mybatis.domain.RealEstate;
import com.bbar.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getRealEstateRent(int rentPrice) {
			
			List<RealEstate> realEstate = realEstateRepository.selectRealEstateRent(rentPrice);
			
			return realEstate;
		}
	
	public List<RealEstate> getRealEstateAreaPrice(int area, int price) {
		
		List<RealEstate> realEstate = realEstateRepository.selectRealEstateAreaPrice(area, price);
		
		return realEstate;
	}
	
	// INSERT TEST
	public int addRealEsateByObect(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		
		return count;
	}
	
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
		return count;
	}
	// UPDATE TEST
	public int addUpdateRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.updateRealEstateByObject(realEstate);
		
		return count;
	}
	
	// DELETE TEST
	public int addDeleteRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.deleteRealEstateByObject(realEstate);
		
		return count;
	}
}
