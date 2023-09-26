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
	
	@Test
	public void 데이터등록() {
		//생성자 사용
		Board board1 = new Board();
		board1.setTitle("1번글");
		board1.setContent("내용입니다");
		boardRepository.save(board1);
		//생성자 사용
		Board board2 = new Board(0,"2번글","내용입니다",null,null);
		boardRepository.save(board2);
		//builder 사용
		Board board3 = Board.builder()
							.title("3번글")
							.content("내용입니다")
							.build();
		boardRepository.save(board3);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = boardRepository.findById(1);  //조회결과를 optional로 반환
		if(result.isPresent()) { //결과값이 있는지 확인
			Board board = result.get(); //값 꺼내기
			System.out.println(board);
		}
	}
	@Test
	public void 데이터전체조회() {
		List<Board> list = boardRepository.findAll(); //조회결과를 리스트로 반환
		for(Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Board> result = boardRepository.findById(1); //1번 게시물 조회
		Board board = result.get(); //엔티티 꺼내기
		board.setContent("내용이수정되었습니다~"); //일부 값 변경
		boardRepository.save(board); //1번이 존재하는지 확인하고 update 실행
	}
	
	@Test
	public void 데이터삭제() {
		boardRepository.deleteById(1);	//1번이 존재하는지 확인하고 delete 실행
	}

	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll();	//테이블을 조회하고 모든 데이터를 삭제함
	}

}
