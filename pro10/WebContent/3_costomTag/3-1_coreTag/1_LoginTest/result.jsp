<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<c:if test="${empty param.userId }">
	아이디를 입력하세요.<br>
</c:if>
<c:if test="${not empty param.userId }">
	<h1>환영합니다. ${param.userId } 님</h1>
</c:if>
	<a href='login.jsp'>로그인 창 이동</a>
</body>
</html>