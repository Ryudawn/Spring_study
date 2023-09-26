package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

/*
* JPQL 문법으로 작성하기
* */
public interface GiftRepository2 extends JpaRepository<Gift, Integer> {

	// 선물의 가격이 '50000'원 이상인 데이터 검색
	// select * from gift where price >= 50000
	@Query("select m from Gift m where m.price >=:price")
	List<Gift> get1(@Param("price") int price);

	// 상품명이 '세트'로 끝나는 데이터 검색
	// SELECT * FROM GIFT WHERE NAME LIKE '%세트';
	@Query("select m from Gift m where m.name like %:name")
	List<Gift> get2(@Param("name") String name);
	
	// 선물의 가격이 '40000'원 이하이고 품목이 '생활용품'인 데이터 검색
	// select * from gift where price <= 40000 and type = 생활용품 
	@Query("select m from Gift m where m.price <= :price and type=:type")
	List<Gift> get3(@Param("price") int price, @Param("type") String type);

}
