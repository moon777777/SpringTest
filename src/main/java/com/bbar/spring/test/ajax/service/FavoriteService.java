package com.bbar.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.test.ajax.domain.Favorite;
import com.bbar.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavorite() {
		
		List <Favorite> favortieList = favoriteRepository.selectFavorite();
		
		return favortieList;
	}
	
	public int addFavorite(
			String name
			, String url) {
		
		int count =  favoriteRepository.insertFavorite(name, url);
		
		return count;
	}
	
	public boolean isDuplicateUrl(String url) {
		int count = favoriteRepository.countByUrl(url);
		
//		if(count > 0) {
//			return true;
//		} else {
//			return false;
//		}
		
		return count > 0;
	}
	
	// 특정 즐겨찾기 삭제
	// input : 삭제 대상 id
	// 기능 : id와 대응되는 즐겨 찾기 삭제
	// output : 뭐 예를 들어 됐는지 확인되는 count 개발은 무조건 input output
	public int deleteFavorite(int id) {
		
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
	}
}
