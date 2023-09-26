package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.Book;
import com.example.demo.entity.Gift;

/*
 * Gift엔티티클래스와 GiftReposiotry인터페이스를 이용하여 다음과 같이 테이블을 만드세요.
 * 다음과 같이 테이블에 데이터를 추가하세요.
 * 그리고 테이블에 데이터를 조회, 수정, 삭제 하세요.
 * */
@SpringBootTest
public class Quiz2 {
	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 데이터일괄등록() {
		List<Gift> list = new ArrayList<>();
		Gift gift1 = new Gift(0,"참치세트","식품",10000);
		Gift gift2 = new Gift(0,"햄세트","식품",20000);
		Gift gift3 = new Gift(0,"샴푸세트","생활용품",30000);
		Gift gift4 = new Gift(0,"세차용품","생활용품",40000);
		Gift gift5 = new Gift(0,"주방용품","생활용품",50000);
		Gift gift6 = new Gift(0,"노트북","가전제품",60000);
		Gift gift7 = new Gift(0,"벽걸이TV","가전제품",70000);
		list.add(gift1);
		list.add(gift2);
		list.add(gift3);
		list.add(gift4);
		list.add(gift5);
		list.add(gift6);
		list.add(gift7);
		giftRepository.saveAll(list);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Gift> result = giftRepository.findById(1);
		if(result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	@Test
	public void 데이터전체조회() {
		List<Gift> list = giftRepository.findAll();
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftRepository.findById(1);
		Gift gift = result.get();
		gift.setPrice(100000);
		giftRepository.save(gift);	
	}
	
	@Test
	public void 데이터삭제() {
		giftRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		giftRepository.deleteAll();
	}
}
