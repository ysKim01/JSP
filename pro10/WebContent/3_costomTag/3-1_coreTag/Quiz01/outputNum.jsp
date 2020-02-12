<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%	
	request.setCharacterEncoding("utf-8");	
%>
<c:set var='num' value="${param.num }" scope='page'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output</title>
</head>
<body>
	<c:if test="${(num%2)==0}">
		<h1>짝수 입니다.</h1>
	</c:if>
	<c:if test="${(num%2)==1}">
		<h1>홀수 입니다.</h1>
	</c:if>
</body>
</html>