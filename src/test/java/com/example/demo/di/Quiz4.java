package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.교사 클래스(Teacher)을 만든다
 * 2.수업 클래스(Class)을 만든다
 * 담당교사를 멤버변수로 가진다
 * 3.스프링컨테이너에 수업와 선생님 객체를 저장한다
 * 4.단위테스트 클래스를 만든다
 * 5.컨테이너에서 수업 객체를 꺼낸다
 * 6.수업이 가지고 잇는 담당교사 객체를 꺼낸다
 * */

@SpringBootTest
public class Quiz4 {

	@Autowired
	Class class1;
	
	@Autowired
	Teacher teacher;
	
	@Test
	void test() {
		System.out.println("class1: " + class1);
		
		System.out.println("teacher: " + teacher);
		
		System.out.println("getTeacher(): " + class1.getTeacher());	
	}
}
