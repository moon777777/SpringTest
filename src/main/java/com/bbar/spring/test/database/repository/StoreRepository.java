package com.bbar.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bbar.spring.test.database.domain.Store;

// 데이터베이스 관련 처리
// Mybatis Framework
@Mapper
public interface StoreRepository {
	
	// store 테이블 모든 행 조회
	public List<Store> selectStoreList();
}
