<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input</title>
</head>
<body>
	<form action='outputNum2.jsp' method='post'>
		숫자 : <input type='text' name='num' size=20 />
		<input type='submit' value='입력'>
		<input type='reset' value='다시입력'>
	</form>
</body>
</html>