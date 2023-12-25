package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 리턴 타입이 void인 경우,url 경로와 일치하는 html 파일을 찾아 반환
 * 파일경로: templates/ + sample/ + ex.html
 * */

@Controller
@RequestMapping("/controller")
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
    }

}
