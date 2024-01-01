package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 리턴 타입이 string인 경우, 문자열 경로와 일치하는 jsp 파일을 찾아 반환
 * 파일경로: /src/main/webapp + /jsp/ex1.jsp
 * */

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public String ex1() {
        return "/jsp/ex1";
    }

}
