package com.bbar.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.test.ajax.domain.Favorite;
import com.bbar.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/favoriteInput";
	}
	
	@GetMapping("/list")
	public String weatherHistory(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavorite();
		
		model.addAttribute(favoriteList);
		return "ajax/favoriteList";
	}
	
	@PostMapping("/create")
	@ResponseBody // 그저 return값을 담기 위해 왜 써야 하니까 
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) {
		
		int count = favoriteService.addFavorite(name, url);
		
		Map<String, String> resultMap = new HashMap<>();

		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}

}
