package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * JPQL 문법으로 작성하기
 * */
public interface OrderRepository2 extends JpaRepository<Order, Integer> {

    // 주소지가 '인천'인 데이터 검색
    // select * from tbl_order where ship_address like '인천%';
    @Query("select m from Order m where m.shipAddress like :address%")
    List<Order> get1(@Param("address") String address);

    // 주문일이 '7월3일'인 데이터 검색
    // select * from tbl_order where order_date = '2023-07-03';
    @Query("select m from Order m where m.orderDate = :orderDate")
    List<Order> get2(@Param("orderDate") LocalDateTime orderDate);
}
