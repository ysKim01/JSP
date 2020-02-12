<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" %>
<%
	request.setCharacterEncoding("utf-8");
	List membersList = new ArrayList();
	MemberVO m1 = new MemberVO("lee","1234","이순신","lee@kg.com");
	MemberVO m2 = new MemberVO("son","1234","손흥민","son@kg.com");
	membersList.add(m1);
	membersList.add(m2);
	request.setAttribute("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="member10.jsp"></jsp:forward>
</body>
</html>








