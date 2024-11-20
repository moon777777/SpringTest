package com.bbar.spring.test.booking.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bbar.spring.test.booking.domain.Booking;

@Mapper
public interface BookingRepository {
	
	public List<Booking> selectBooking();
	
	public int delteBooking(@Param("id")int id);
	
	public int insertBooking(
			@Param("name") String name
			, @Param("date") LocalDate date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state
	);
	
	public Booking checkBooking( // 한행만 저장
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber
			);

}
