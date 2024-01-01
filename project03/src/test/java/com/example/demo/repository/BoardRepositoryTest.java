package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;

	/*
	* 테스트 후에 테이블에 데이터가 등록됬는지 확인
	* */
	@Test
	public void 데이터등록() {

		Board board1 = new Board(0, "1번글", "내용입니다", null, null); // 날짜 생략
		boardRepository.save(board1); // 등록일과 수정일이 현재시간으로 자동 등록됨

		Board board2 = Board.builder().title("2번글").content("내용입니다").build(); // 날짜 생략
		boardRepository.save(board2);
	}

	/*
	* 테스트전에 테이블에 데이터가 있는지 확인
	* */
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = boardRepository.findById(1); // 조회결과를 optional로 반환
		if (result.isPresent()) { // 결과값이 있는지 확인
			Board board = result.get(); // 값 꺼내기
			System.out.println(board);
		}
	}

	@Test
	public void 데이터전체조회() {
		List<Board> list = boardRepository.findAll(); // 조회결과를 리스트로 반환
		for (Board board : list) {
			System.out.println(board);
		}
	}

	@Test
	public void 데이터수정() {
		Optional<Board> result = boardRepository.findById(1); // 1번 게시물 조회
		Board board = result.get(); // 엔티티 꺼내기
		board.setContent("내용이수정되었습니다~"); // 일부 값 변경
		boardRepository.save(board); // 1번이 존재하는지 확인하고 update 실행
	}

	@Test
	public void 데이터삭제() {
		boardRepository.deleteById(1); // 1번이 존재하는지 확인하고 delete 실행
	}

	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll(); // 테이블을 조회하고 모든 데이터를 삭제함
	}

}
