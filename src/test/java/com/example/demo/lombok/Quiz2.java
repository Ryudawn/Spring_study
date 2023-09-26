package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * 1.자동차클래스(Car)을 설계한다
 * 멤버변수: 모델명, 제조사, 색
 * 기능: 
 * 모든멤버변수의 getter/setter, 
 * 디폴트생성자, 
 * 모든멤버변수를 초기화하는 생성자, 
 * 도서정보를 반환하는 기능
 *
 * 2.자동차 인스턴스를 생성하고, 자동차 클래스가 가진 기능을 테스트한다
 * */
@SpringBootTest
public class Quiz2 {

	@Test //단위테스트
	void test() {
		Car car1 = new Car();
		car1.setModel("소나타");
		car1.setCompany("현대");
		car1.setColor("블랙");
		System.out.println(car1.getModel());
		System.out.println(car1.getCompany());
		System.out.println(car1.getColor());
		
		Car car2 = new Car("베뉴","현대","그레이");
		System.out.println(car2);
	}
}
