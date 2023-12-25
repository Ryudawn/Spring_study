package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService boardService;
	
	@Test
	public void 조건검색() {
//		Page<BoardDTO> page = boardService.getList(1);
//		List<BoardDTO> list = page.getContent();
//		System.out.println(list);
	}
	
}
