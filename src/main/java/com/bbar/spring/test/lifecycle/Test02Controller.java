package com.bbar.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> meResponse() {
		List <Map<String, Object>> movieList = new ArrayList<>();
		Map <String, Object> movieInfo = new HashMap<>();
		movieInfo.put("rate", 15);
		movieInfo.put("director", "봉준호");
		movieInfo.put("time", 131);
		movieInfo.put("title", "기생충");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 0);
		movieInfo.put("director", "로베르토 베니니");
		movieInfo.put("time", 116);
		movieInfo.put("title", "인생은 아름다워");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 12);
		movieInfo.put("director", "크리스토퍼 놀란");
		movieInfo.put("time", 147);
		movieInfo.put("title", "인셉션");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 19);
		movieInfo.put("director", "윤종빈");
		movieInfo.put("time", 133);
		movieInfo.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 15);
		movieInfo.put("director", "프란시스 로렌스");
		movieInfo.put("time", 137);
		movieInfo.put("title", "헝거게임");
		movieList.add(movieInfo);
		
		return movieList;
	}
	
	@RequestMapping("/2")
	public List<Board> objectResponse() {
		List <Board> boardList = new ArrayList<>();
		boardList.add(new Board("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다"));
		boardList.add(new Board("헐 대박", "bada", "오늘 목요일이 었어... 금요일인줄"));
		boardList.add(new Board("오늘 데이트 한 이야기 해드릴게요.", "dulmary", "...."));
		
		return boardList;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Board> entityResponse() {
		Board me =  new Board("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다");
		
		ResponseEntity<Board> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
}
