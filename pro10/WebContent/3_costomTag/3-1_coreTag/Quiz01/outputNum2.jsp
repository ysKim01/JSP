<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%	
	request.setCharacterEncoding("utf-8");	
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output</title>
</head>
<body>
	<h1>입력값(스크립트릿) : <%=num %></h1>
	<h1>입력값(\$) : ${"<%=num%>" }</h1>
	<c:if test="${(num%2)==0}">
		<h1>짝수 입니다.</h1>
	</c:if>
	<c:if test="${(num%2)==1}">
		<h1>홀수 입니다.</h1>
	</c:if>
</body>
</html>