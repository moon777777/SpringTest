package com.bbar.spring.test.mvc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbar.spring.test.mvc2.domain.Realtor;
import com.bbar.spring.test.mvc2.service.RealtorService;

@RequestMapping("/mvc2/realtor")
@Controller
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/create")
	public String createRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model
			) {
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtorByObject(realtor);
		
		model.addAttribute("title", "공인중개사 정보");
		model.addAttribute("result", realtor);
		return "mvc/realtorInfo";
		
		
	}
	
//	//확인
	@GetMapping("/input")
	public String realtorInput() {
		return "mvc/realtorInput";
	}
}
