package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class Quiz6 {

	@Autowired
	OrderRepository2 orderRepository;

	@Test
	public void 주소지가인천인_주문검색() {
        List<Order> list = orderRepository.get1("인천");
        for(Order order : list) {
            System.out.println(order);
        }
	}

	@Test
	public void 주문일이7월3일인_주문검색() {
		LocalDateTime localDate = LocalDateTime.of(2023,7,3,0,0,0);
		List<Order> list = orderRepository.get2(localDate);
		for(Order order : list) {
			System.out.println(order);
		}
	}

}
