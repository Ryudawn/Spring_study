package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;
	
	@Test
	public void 일반사용자등록() {
		MemberDTO memberDTO = MemberDTO.builder()
				.id("user")
				.password("1234")
				.name("둘리")
				.role("ROLE_USER")
				.build();
		service.register(memberDTO);
	}
	
	@Test
	public void 관리자등록() {
		MemberDTO memberDTO = MemberDTO.builder()
				.id("admin")
				.password("1234")
				.name("또치")
				.role("ROLE_ADMIN")
				.build();
		service.register(memberDTO);
	}
	
}
