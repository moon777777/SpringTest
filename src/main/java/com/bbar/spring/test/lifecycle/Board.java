package com.bbar.spring.test.lifecycle;

import org.springframework.http.ResponseEntity;

public class Board {
	
	private String title;
	private String user;
	private String content;
	
	public Board(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "title : " + title + " user : " + user + " content : " + content;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getContent() {
		return content;
	}
	

}
