package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.다음과 같이 카페매니저(Manager)클래스를 만드세요
 * - 아무것도 없음
 * 2.다음과 같이 카페(Cafe)클래스를 만드세요
 * - 속성: 카페매니저
 * 3.스프링컨테이너에 카페, 매니저 객체를 저장하세요
 * 4.단위테스트 클래스를 만드세요
 * 5.컨테이너에서 카페 객체를 꺼내세요
 * 6.카페의 매니저를 꺼내세요
 * */

@SpringBootTest
public class Quiz3 {

	@Autowired
	Cafe cafe;
	
	@Autowired
	Manager manager;
	
	@Test
	void test() {
		System.out.println("cafe: " + cafe);
		
		System.out.println("manager: " + manager);
		
		System.out.println("getManager(): " + cafe.getManager());	
	}
}
