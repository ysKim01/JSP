<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="score" value="${param.score }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과</title>
</head>
<body>
<c:if test="${empty score }">
	점수를 입력하세요.<br>
</c:if>
<c:if test="${not empty score }">
	<h1>시험점수 : ${score }점</h1>
	<c:choose>
		<c:when test="${score>=90}">
			<h1>A 학점 입니다.</h1>
		</c:when>
		<c:when test="${score>=80 && score<90}">
			<h1>B 학점 입니다.</h1>
		</c:when>
		<c:when test="${score>=70 && score<80}">
			<h1>C 학점 입니다.</h1>
		</c:when>
		<c:when test="${score>=60 && score<70}">
			<h1>D 학점 입니다.</h1>
		</c:when>
		<c:otherwise>
			<h1>F 학점 입니다.</h1>
		</c:otherwise>
	</c:choose>
</c:if>
<a href='scoreTest.jsp'>점수입력창 창 이동</a>
</body>
</html>