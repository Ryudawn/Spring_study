package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {

	// 템플릿 레이아웃1
	@GetMapping("/exLayout1")
	public void ex1() { // 레이아웃을 반환
	}

	// 템플릿 레이아웃1
	@GetMapping("/exLayout1-2")
	public void ex2() {
	}

	// 템플릿 레이아웃2
	@GetMapping("/fragment2")
	public void ex3() { // 조각페이지를 반환
	}

	// 템플릿 레이아웃2
	@GetMapping("/fragment3")
	public void ex4() {
	}

	// 부트스트랩
	@GetMapping("/exSidebar")
	public void ex5() {
	}

}
