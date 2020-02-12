<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sec01.ex01.*" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberVO member = new MemberVO("lee","1234","이순신","lee@kg.com");
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="member9.jsp"></jsp:forward>
</body>
</html>








