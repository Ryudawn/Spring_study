package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.도서클래스(Book)을 설계한다
 * 멤버변수: 제목, 가격, 출판사, 페이지수
 * 기능: 
 * 모든멤버변수의 getter/setter, 
 * 디폴트생성자, 
 * 모든멤버변수를 초기화하는 생성자, 
 * 도서정보를 반환하는 기능
 *
 * 2.도서 인스턴스를 생성하고, 도서 클래스가 가진 기능을 테스트한다
 * */
@SpringBootTest
public class Quiz1 {

	@Test //단위테스트
	void test() {
		Book book1 = new Book();
		book1.setTitle("자바프로그래밍입문");
		book1.setPrice(20000);
		book1.setCompany("한빛미디어");
		book1.setPage(300);
		System.out.println(book1.getTitle());
		System.out.println(book1.getPrice());
		System.out.println(book1.getCompany());
		System.out.println(book1.getPage());
		
		Book book2 = new Book("스프링부트",30000,"남가락북스",400);
		System.out.println(book2);
	}
}
