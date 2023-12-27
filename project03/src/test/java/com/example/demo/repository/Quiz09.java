package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class Quiz09 {

	@Autowired
	GiftRepository2 giftRepository;
	
	@Test
	public void 가격이5만원이상인_선물검색() {
		List<Gift> list = giftRepository.get4(50000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 이름이세트로끝나는_선물검색() {
		List<Gift> list = giftRepository.get5("세트");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 가격은4만원이하고_품목은생활용품인_선물검색() {
		List<Gift> list = giftRepository.get6(40000,"생활용품");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
}
