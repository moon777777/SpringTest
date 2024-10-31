package com.bbar.spring.test.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String stringResponse() {
		return "Hello World!!";
	}

}
