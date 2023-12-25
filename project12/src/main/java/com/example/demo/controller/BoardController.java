package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String search, Model model) {
		Page<BoardDTO> list = service.getList(page, search);
		model.addAttribute("list", list);	
		System.out.println("검색키워드: " + search);
	}

	@GetMapping("/register")
	public void register() {
	}

	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes, Principal principal) {
		String memberId = principal.getName(); 
		dto.setWriter(memberId); //작성자에 로그인한 회원의 아이디 저장
		int no = service.register(dto);
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/board/list";
	}

	@GetMapping("/read")
	public void read(int no, @RequestParam(defaultValue = "0") int page, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}

	@GetMapping("/modify")
	public void modify(int no, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}

	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("no", dto.getNo());
		return "redirect:/board/read";
	}

	@PostMapping("/remove")
	public String removePost(int no) {
		service.remove(no);
		return "redirect:/board/list";
	}

}
