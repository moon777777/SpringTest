package com.bbar.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.test.database.domain.Store;
import com.bbar.spring.test.database.service.StoreService;

// 얘는 request, response 만 처리
@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	//store 테이블의 모든 정보를 json 으로 response에 담는다.
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
		// store 정보를 얻어 오기 이것은 직접적인 요청과 응답이 아니다
		// 즉 이것은 다른애가 해야한다.
	}
}
