<%@ page import="com.example.demo.repository.MemberRepository" %>
<%@ page import="com.example.demo.entity.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<@
	@Autowired
	MemberRepository repository;

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Member member = Member.builder()
                        .userId(username).password(password)
                        .build();
    Member newMember = repository.save(member);
@>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <p>
        <%= newMember.getNo() %> 번 회원을 등록 했습니다!
    </p>
</body>
</html>