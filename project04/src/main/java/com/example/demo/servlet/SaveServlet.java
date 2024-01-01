package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveServlet", urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet {
	
	@Autowired
	MemberRepository repository;

	// 사용자 요청을 처리하는 메소드 재정의
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 요청 메세지에서 사용자가 전달한 파라미터 꺼내기
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // 회원 추가
        Member member = Member.builder()
        		.userId(username).password(password)
        		.build();
        Member newMember = repository.save(member);
		
		// 응답 메세지 만들기
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
		
		// html 내용 작성
        PrintWriter w = response.getWriter();
        
        w.write("<html>\n" +
                "<body>\n" +
                newMember.getNo() + "번 회원을 등록 했습니다!\n" +
                "</body>\n" +
                "</html>");

	}

}
