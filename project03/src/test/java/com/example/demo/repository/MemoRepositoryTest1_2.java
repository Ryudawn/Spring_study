package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;

/*
 * 페이징 및 정렬기능 사용하기
 * */
@SpringBootTest
public class MemoRepositoryTest1_2 {

	@Autowired
	MemoRepository repository;

	@Test
	void 메모데이터100개등록() {
		// 1~100까지 숫자를 가지는 스트림을 생성하고, forEach 최종연산자로 반복작업을 수행
		// 숫자를 하나씩 꺼내면서 새로운 메모를 테이블에 추가
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo.builder().text("Sample.." + i).build();
			repository.save(memo);
		});
	}

	@Test
	void 페이징처리() {
		// 페이지번호와 데이터개수를 담아서 페이지 정보 생성
		Pageable pageable = PageRequest.of(0, 10); // 페이지번호 바꿔보기

		// 페이지 정보를 전달하여 데이터 조회하기
		Page<Memo> page = repository.findAll(pageable);

		// 페이지안에 담긴 데이터 꺼내기
		List<Memo> list = page.getContent();
		System.out.println(list);

		// 페이지 부가 정보
		System.out.println("총 페이지:" + page.getTotalPages());
		System.out.println("현재 페이지 번호:" + page.getNumber());
		System.out.println("페이지당 데이터 개수:" + page.getSize());
		System.out.println("다음 페이지 존재 여부:" + page.hasNext());
		System.out.println("시작 페이지 여부:" + page.isFirst());
	}

	@Test
	void 정렬조건추가하기() {

		// no 필드를 기준으로 역정렬하는 조건을 생성
		Sort sort = Sort.by("no").descending();

		// 페이지번호, 데이터개수, 정렬조건을 담아서 페이지 정보 생성
		Pageable pageable = PageRequest.of(0, 10, sort);

		// 페이지 정보를 전달하여 데이터 조회
		Page<Memo> page = repository.findAll(pageable);

		List<Memo> list = page.getContent();

		// 메모번호를 기준으로 역정렬된 데이터가 조회됨
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

}
