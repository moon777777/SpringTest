package com.bbar.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.jpa.domain.Company;
import com.bbar.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		
		if(optionalCompany.isPresent()) {
			// optional 객체에 데이터 객체가 null이 아닌경우
			// 새로운 표현 방식
			Company company = optionalCompany.get();
			
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			Company result = companyRepository.save(company);
			return result;
		}
		
		return null;
		
	}
	
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		// 람다식 표현
		// null이 아닐때 수행할 기능 등록
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
		
		
	}
}
