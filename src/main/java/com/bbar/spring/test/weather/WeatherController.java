package com.bbar.spring.test.weather;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
			@RequestParam("date") LocalDate date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeend
			, Model model
			) {
		
		Weather weatherHistory = new Weather();
		weatherHistory.setDate(date);
		weatherHistory.setWeather(weather);
		weatherHistory.setTemperatures(temperatures);
		weatherHistory.setPrecipitation(precipitation);
		weatherHistory.setMicroDust(microDust);
		weatherHistory.setWindSpeed(windSpeend);
		
		int count = weatherService.addWeatherByObject(weatherHistory);
		
		return "redirect:list";
		
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "thymeleaf/weather/input";
	}
	

}
