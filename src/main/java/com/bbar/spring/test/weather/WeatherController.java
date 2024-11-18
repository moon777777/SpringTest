package com.bbar.spring.test.weather;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbar.spring.test.weather.domain.Weather;
import com.bbar.spring.test.weather.service.WeatherService;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	@GetMapping("/list")
	public String weatherHistory(Model model) {
		
		List<Weather> weatherList = weatherService.getWeatherList();
		
		LocalDate localDate = LocalDate.now();
		
		model.addAttribute(weatherList);
		model.addAttribute(localDate);
		return "thymeleaf/weather/list";
	}
	
	@GetMapping("/create")
	public String createWeather(
			@DateTimeFormat(pattern="yyyy년 M월 d일") // 변환이 불가능한경우 이 타입으로 가능하게 해줌
			@RequestParam("date") LocalDate date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed
			, Model model
//			, @ModelAttribute Weather weather // 위에 requestParam 쓰기 귀찮을때 이거 씀 근데 나는 객체 형태라 이거 연
			) {
		
		Weather weatherHistory = new Weather();
		weatherHistory.setDate(date);
		weatherHistory.setWeather(weather);
		weatherHistory.setTemperatures(temperatures);
		weatherHistory.setPrecipitation(precipitation);
		weatherHistory.setMicroDust(microDust);
		weatherHistory.setWindSpeed(windSpeed);
		
		int count = weatherService.addWeatherByObject(weatherHistory);
		
		return "redirect:/thymeleaf/weather/list";
		
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "thymeleaf/weather/input";
	}
	

}
