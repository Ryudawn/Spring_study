package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.다음과 같이 학생(Student) 클래스을 설계하세요
 * 속성: 학번, 이름, 나이
 * 기능: 모든멤버변수의 getter/setter, 디폴트생성자, 모든멤버변수를 초기화하는 생성자, 학생정보를 반환하는 기능
 * 2.학생의 인스턴스를 2개 생성하세요 
 * 3.학생의 모든 정보를 출력하세요
 * */
@SpringBootTest
public class Quiz3 {

	@Test
	void test() {		
		Student student = new Student();
		student.setStudentId(1001);
		student.setStudentName("둘리");
		student.setAge(15);
		System.out.println(student.getStudentId());
		System.out.println(student.getStudentName());
		System.out.println(student.getAge());
		
		Student student2 = new Student(1002, "도우너", 16);
		System.out.println(student.toString());
		
	}
}
