package com.bbar.spring.test.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.weather.domain.Weather;
import com.bbar.spring.test.weather.repository.WeatherRepository;


@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> getWeatherList() {
		
		List<Weather> weatherList = weatherRepository.selectWeather();
		
		return weatherList;
	}
	
	public int addWeatherByObject(Weather weather) {
		int count = weatherRepository.insertWeatherByObject(weather);
		
		return count;
	}
}
