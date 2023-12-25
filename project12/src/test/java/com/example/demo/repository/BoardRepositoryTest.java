package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 게시물등록() {
		List<Board> list = new ArrayList<>();
		Member member = Member.builder().id("user").build();
		Board board1 = Board.builder()
				.title("aaa")
				.content("내용입니다")
				.writer(member)
				.build();
		Board board2 = Board.builder()
				.title("aaz")
				.content("내용입니다")
				.writer(member)
				.build();
		Board board3 = Board.builder()
						.title("bbb")
						.content("내용입니다")
						.writer(member)
						.build();
		Board board4 = Board.builder()
				.title("bbz")
				.content("내용입니다")
				.writer(member)
				.build();
		list.add(board1);
		list.add(board2);
		list.add(board3);
		list.add(board4);
		
		boardRepository.saveAll(list);
	}
	
	@Test
	public void 조건검색() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("no").descending());
		Page<Board> result = boardRepository.findByTitleContaining("aaa", pageable);
		List<Board> list = result.getContent();
		System.out.println(list);
	}
	
}
