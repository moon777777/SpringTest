package com.bbar.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.test.mybatis.domain.RealEstate;
import com.bbar.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/realEstate/1")
	@ResponseBody
	public RealEstate realEstae(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/realEstate/2")
	@ResponseBody
	public List<RealEstate> realEstateRent(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateRent(rentPrice);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/realEstate/3")
	@ResponseBody
	public List<RealEstate> realEstateAreaPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateAreaPrice(area, price);
		
		return realEstate;
	}
	
}
