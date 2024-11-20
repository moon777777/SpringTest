package com.bbar.spring.test.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.test.booking.domain.Booking;
import com.bbar.spring.test.booking.service.BookingService;
import com.bbar.spring.test.mvc2.domain.Realtor;

@RequestMapping("/ajax/booking")
@Controller
public class bookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.getBooking();
		LocalDate localDate = LocalDate.now();
		
		model.addAttribute(bookingList);
		model.addAttribute("localDateTime", localDate);
		return "booking/list";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "booking/input";
	}
	
	// 육하원칙 언제 어디서 무엇을 어떻게 왜
	// 언제 : 사용자가 예약정보를 입력하고 저장을 수행하고자 할때
	// 어디서 : 서버에서
	// 무엇을 : 예약 정보를 저장한다
	// 어떻게 : 예약정보를 booking 테이블에 insert 한다.
	// 왜 : 테이블에 저장해야 얻어올수 있으니까
	// input(request) : 예약에 필요한 예약자 정보
	// 기능 : 전달된 예약자 정보를 저장한다.
	// 
	// output (response) :
	
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createBooking(
			@DateTimeFormat(pattern="yyyyMMdd")
			@RequestParam("name") String name
			, @RequestParam("date") LocalDate date 
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/main")
	public String mainBooking( ) {
		return "booking/check";
	}
	
	// 언제 : 사용자가 이름과 전화번호를 입력하고 조회를 요청했을때
	// 어디서 : 서버에서
	// input : 예약자 이름, 전화 번호
	// 기능 : 
	// 무엇을 : 이름과 전화번호가 일치하는 사용자 정보 조회
	// 어떻게 : booking 테이블에 이름과 전화번호를 조건으로 일치하는 행 조회 select
	// 왜 : 예약자의 모든 정보가 필요하니까
	// output : 예약자 정보
	
	@GetMapping("/info")
	@ResponseBody
	public Map<String, Object> bookingInfo(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber
			) {
		Booking booking = bookingService.getBooking(name, phoneNumber);
		
		Map<String, Object> resultMap = new HashMap<>();
		// 친절한 규격
		// 조회 성공 : {"result":"success", "item":{"name":"김인규", "day":1, "headcount":2, ......}}
		// 조회 실패 : {"result":"fail"}
		if(booking != null) {
			resultMap.put("result", "success");
			resultMap.put("item", booking);
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
}
