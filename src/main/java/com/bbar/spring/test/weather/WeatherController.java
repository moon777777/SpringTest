package com.bbar.spring.test.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf")
@Controller
public class WeatherController {
	
	@GetMapping("/test04")
	public String test04() {
		return "thymeleaf/test04";
	}
	
	@GetMapping("/test04/input")
	public String test04Input() {
		return "thymeleaf/test04Input";
	}

}
