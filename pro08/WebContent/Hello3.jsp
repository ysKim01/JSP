<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "반응형2";
	String age = "20";
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
	<h1>나이+10은 <%=Integer.parseInt(age)+10%>입니다.</h1>
</body>
</html>