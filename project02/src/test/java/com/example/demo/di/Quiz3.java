package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.카페매니저 클래스(Manager)을 만든다
 * 2.카페 클래스(Cafe)을 만든다
 * 카페매니저를 멤버변수로 가진다
 * 3.스프링컨테이너에 카페와 매니저 객체를 저장한다
 * 4.단위테스트 클래스를 만든다
 * 5.컨테이너에서 카페 객체를 꺼낸다
 * 6.카페가 가지고 있는 매니저 객체를 꺼낸다
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
