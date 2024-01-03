package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDTO;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@GetMapping("/ex1")
	public void ex1() {
		// 리턴 타입이 void인 경우,url 경로와 일치하는 html 파일을 찾아 반환
		// 템플릿경로: /templates/sample/ex1.html
	}

	@GetMapping("/ex2")
	public void ex2(Model model) { // Model은 화면에 값을 전달하는 역할
		model.addAttribute("msg", "안녕하세요"); // 모델에 문자열을 담기 (첫번째인자:변수명, 두번째인자:값)
	}

	@GetMapping("/ex3")
	public void ex3(Model model, String param) { // 파라미터 수집
		model.addAttribute("msg", param); // 화면에 파라미터 전달
	}

	@GetMapping("/ex4")
	public void ex4(Model model) {
		model.addAttribute("msg", "hello");
	}

	@GetMapping("/ex5")
	public void ex5(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDateTime.now());
		model.addAttribute("dto", sampleDTO); // 화면에 객체 전달

		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1, "aaa", LocalDateTime.now()));
		list.add(new SampleDTO(2, "bbb", LocalDateTime.now()));
		list.add(new SampleDTO(3, "ccc", LocalDateTime.now()));
		model.addAttribute("list", list); // 화면에 리스트 전달
	}

	@GetMapping("/ex6")
	public void ex6(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1, "aaa", LocalDateTime.now()));
		list.add(new SampleDTO(2, "bbb", LocalDateTime.now()));
		list.add(new SampleDTO(3, "ccc", LocalDateTime.now()));
		model.addAttribute("list", list); // 화면에 리스트 전달
	}

	@GetMapping("/ex7")
	public void ex7(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDateTime.now());
		model.addAttribute("result", "success"); // 화면에 문자열 전달
		model.addAttribute("dto", sampleDTO); // 화면에 객체 전달
	}

	@GetMapping("/ex8")
	public void ex8(Model model) {
		model.addAttribute("date", LocalDateTime.now()); // 화면에 현재시간 전달
	}

	// 템플릿 레이아웃1
	@GetMapping("/exLayout1")
	public void ex7() { // 레이아웃을 반환
	}

	// 템플릿 레이아웃1
	@GetMapping("/exLayout1-2")
	public void ex8() {
	}

	// 템플릿 레이아웃2
	@GetMapping("/fragment2")
	public void ex9() { // 조각페이지를 반환
	}

	// 템플릿 레이아웃2
	@GetMapping("/fragment3")
	public void ex10() {
	}

	// 부트스트랩
	@GetMapping("/fragment4")
	public void ex11() {
	}

}
