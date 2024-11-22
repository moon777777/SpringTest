package com.bbar.spring.test.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.test.jpa.domain.Recruit;
import com.bbar.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit/read")
@Controller
public class RecruitController {
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	@ResponseBody
	public Recruit recruit1() {
//		id가 8인 공고를 조회하고 아래와 같이 출력하세요.
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
		
	}
	
	@GetMapping("/2")
	@ResponseBody
	public List<Recruit> recruit2(@RequestParam("developId") int developId) {
		
//		Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
		List<Recruit> recruitList = recruitRepository.findBydevelopId(developId);

//		

		return recruitList;
	}
	
	@GetMapping("/3")
	@ResponseBody
	public List<Recruit> recruit3() {
		List<Recruit> recruitList = null;
		
		// 웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
//		recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		// 정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
		
//		recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
//		계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
		
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
//		성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
		
//		recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
//		마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
		
		recruitList = recruitRepository.selectRecruit(LocalDate.of(2026, 4, 10), 8100, "정규직");
		
		return recruitList;
	}

}
