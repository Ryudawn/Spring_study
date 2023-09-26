package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.Dog 클래스를 만든다
 * "왕왕 짖는다" 라는 메세지를 출력하는 sound() 함수를 가지고 있다
 * 2.스프링컨테이너에 강아지 객체를 저장한다
 * 3.단위테스트 클래스를 만든다
 * 4.컨테이너에서 강아지 객체를 꺼내고 sound() 함수를 호출한다
 * */
@SpringBootTest
public class Quiz1 {

	@Autowired
	Dog dog;
	
	@Test
	void 강아지테스트() {
		dog.sound();
	}
}
