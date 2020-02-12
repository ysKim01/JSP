<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='contextPath' value='${pageContext.request.contextPath}'/>
<!-- contextPath : 프로젝트 까지의 경로 -->
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='result.jsp'>
		아이디 : <input type='text' name='id' size=20 />
		패스워드 : <input type='password' name='pw' size=20 />
		<input type='submit' value='로그인'>
		<input type='reset' value='다시입력'>
	</form>
	<br><br>
	<a href='${contextPath }/3_costomTag/3-1_coretag/memberForm.jsp'>가입하기</a>
</body>
</html>