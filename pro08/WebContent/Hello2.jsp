<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "반응형2";
%>
<%
	String age = request.getParameter("age");
	// url에 age=?? 입력하면 나옴 ex)http://localhost:8080/pro08/Hello2.jsp?age=33
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>
	<h1>안녕하세요 <%=name%></h1>
	<h2>나이는 <%=age%> 입니다.</h2>
</body>
</html>