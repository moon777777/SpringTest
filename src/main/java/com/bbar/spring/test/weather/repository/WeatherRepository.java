package com.bbar.spring.test.weather.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bbar.spring.test.weather.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> selectWeather();
	
	public int insertWeatherByObject(Weather weather);
}
