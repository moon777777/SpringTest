package com.bbar.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbar.spring.test.mvc.domain.Seller;
import com.bbar.spring.test.mvc.service.SellerService;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature
			) {
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		
		return "redirect:/mvc/seller/info";
	}
	
	
	@GetMapping("/info")
	public String sellerInfo(Model model, @RequestParam(value = "id", required = false) Integer id) { //required 는 필수인지 아닌지 Integer Wrapper class primitive를 객체형태로 다룰수 있게
		
		Seller seller = null;
		if(id == null) {			
			seller = sellerService.getLastSeller();			
			
		} else {
			seller = sellerService.getSearchSeller(id);
			
		}
		model.addAttribute("title", "판매자 정보");
		model.addAttribute("result", seller);
	
		return "mvc/sellerInfo";
			
	}
	
}
