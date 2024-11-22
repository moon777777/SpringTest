package com.bbar.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bbar.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	
	// company id가 파라미터 행 조회
	public List<Recruit> findBydevelopId(int developId);
	
	public List<Recruit> findByPositionAndType(String position, String type);
	
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	@Query(value="SELECT * FROM `recruit` WHERE `deadline` > :deadline AND `salary` >= :salary AND `type` = :type ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectRecruit(@Param("deadline") LocalDate deadline,@Param("salary") int salary,@Param("type") String type);
						 
}
