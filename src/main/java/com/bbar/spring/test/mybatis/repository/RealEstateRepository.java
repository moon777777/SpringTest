package com.bbar.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bbar.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateRent(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateAreaPrice(@Param("area") int area, @Param("price") int price);
	
	// INSERT TEST
	public int insertRealEstateByObject(RealEstate realEstate);
	
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice
			);
	// UPDATE TEST
	public int updateRealEstateByObject(RealEstate realestate);
	
	// DELETE TEST
	public int deleteRealEstateByObject(RealEstate realestate);
}


