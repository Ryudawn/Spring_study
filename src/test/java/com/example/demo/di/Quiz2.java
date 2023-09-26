package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.Cat 클래스를 만든다
 * "쥐를 먹는다" 라는 메세지를 출력하는 eat()메소드를 가지고 있다
 * 2.스프링컨테이너에 고양이 객체를 저장한다
 * 3.단위테스트 클래스를 만든다
 * 3.컨테이너에서 고양이 객체를 꺼내고, eat()메소드를 호출한다.
 * */

@SpringBootTest
public class Quiz2 {

	@Autowired
	Cat cat;

	@Test
	void 고양이테스트() {
		cat.eat();
	}
}
