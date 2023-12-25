package com.example.demo.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService service;

	//게시물별 댓글 목록 조회
	@ResponseBody
	@GetMapping("/list")
	public List<CommentDTO> list(int boardNo) {
		HashMap<String,List<CommentDTO>> map = new HashMap<>();
		List<CommentDTO> commentlist = service.getListByBoardNo(boardNo);
//		map.put("commentlist", commentlist);
		
		return commentlist;
	}
	
	@ResponseBody
	@PostMapping("/register")
	public HashMap<String,Boolean> register(CommentDTO dto, Principal principal) {
		HashMap<String,Boolean> map = new HashMap<>();
		String id = principal.getName();
		dto.setWriter(id);		
		service.register(dto);
		map.put("success", true);
		return map;
	}
	
	@ResponseBody
	@GetMapping("/remove")
	public HashMap<String,Boolean> remove(int commentNo) {
		HashMap<String,Boolean> map = new HashMap<>();
		service.remove(commentNo);
		map.put("success", true);
		return map;
	}

}
