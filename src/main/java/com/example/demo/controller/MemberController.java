package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/member") //중간경로 제거
public class MemberController {

	@Autowired
	private MemberService service;

//	@GetMapping("/list")
	@GetMapping("/member/list") //주소수정
	public void list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<MemberDTO> list = service.getList(page);
		model.addAttribute("list", list);	
	}

	@GetMapping("/register")
	public String register() {
		return "member/register"; //html 경로 수정
	}

	@PostMapping("/register")
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
			return "redirect:/"; //메인화면으로 이동하기
		}else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/register"; //등록화면으로 돌아가기
		}
	}

	//	@GetMapping("/read")
	@GetMapping("/member/read") //주소수정
	public void read(String id, @RequestParam(defaultValue = "0") int page, Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}

}
