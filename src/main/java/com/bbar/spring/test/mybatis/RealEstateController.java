package com.bbar.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.test.mybatis.domain.RealEstate;
import com.bbar.spring.test.mybatis.service.RealEstateService;

@RequestMapping("/mybatis/realEstate")
@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/select/1")
	@ResponseBody
	public RealEstate realEstae(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<RealEstate> realEstateRent(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateRent(rentPrice);
		
		return realEstate;
	}
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<RealEstate> realEstateAreaPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateAreaPrice(area, price);
		
		return realEstate;
	}
	// INSERT TEST
	@RequestMapping("/create/1")
	@ResponseBody
	public String createRealEstateByObject() {
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEsateByObect(realEstate);
		
		return "삽입 결과 : " + count;
	}
	
	@RequestMapping("/create/2")
	@ResponseBody
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = realEstateService.addRealEstate(realtorId ,"썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
	}
	// UPDATE TEST
	@RequestMapping("/update")
	@ResponseBody
	public String updateRealEstateByObject() {
		RealEstate realEstate = new RealEstate();
		
		realEstate.setId(28);
		realEstate.setType("전세");
		realEstate.setPrice(70000);
		
		int count = realEstateService.addUpdateRealEstateByObject(realEstate);
		
		return "수정 성공 : " + count;
	}
	
	// DELETE TEST
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRealEstateByObject(@RequestParam("id") int id) {
		RealEstate realEstate = new RealEstate();
		
		realEstate.setId(id);
		
		int count = realEstateService.addDeleteRealEstateByObject(id);
		
		return "삭제 성공 : " + count;
	}
}
