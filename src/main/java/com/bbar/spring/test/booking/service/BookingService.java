package com.bbar.spring.test.booking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.booking.domain.Booking;
import com.bbar.spring.test.booking.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getBooking() {
		List<Booking> bookingList = bookingRepository.selectBooking();
		
		return bookingList;
	}
	
	public int deleteBooking(int id) {
		int count = bookingRepository.delteBooking(id);
		return count;
	}
	
	public int addBooking(
			String name
			, LocalDate date
			, int day
			, int headcount
			,  String phoneNumber) {
		
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
		
		return count;
		
	}
	
	public Booking getBooking(
			String name
			, String phoneNumber
			) {
		Booking booking = bookingRepository.checkBooking(name, phoneNumber);
		
		return booking ;
	}

}
