package com.bbar.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.database.domain.Store;
import com.bbar.spring.test.database.repository.StoreRepository;

// 로직(business) 담당
// 데이터를 수정 가공
// 그외 복잡한 기능 수행
// 여기서는 spring 사용법이 거의 사용되지 않고 java에서만의 문법이 전부라 
// 해도 과언이 아니다 request와 response를 제외한 모든 기능
// 인터페이스를 불러올수도 없고 spring이 직접 불러온다 싱글턴 패턴
@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// store 글을 모두 얻어오기

	public List<Store> getStoreList() {
	
	// store 테이블 조회 결과 얻어오기
	// 근데 이것도 여기서 안함
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
}
