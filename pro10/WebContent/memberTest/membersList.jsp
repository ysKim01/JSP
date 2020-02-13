<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"
	import='java.util.*, sec02.ex01.*'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% 	request.setCharacterEncoding("utf-8"); %>
<%-- forward이므로 따로 파라미터값을 안받아도 된다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 출력 창</title>
</head>
<body>
	<table align='center' border='1'>
		<tr align='center' bgcolor='lightgreen'>
			<td width='7%'><b>아이디</b></td>
			<td width='7%'><b>패스워드</b></td>
			<td width='7%'><b>이름</b></td>
			<td width='7%'><b>이메일</b></td>
			<td width='7%'><b>가입일</b></td>
		</tr>
	<c:choose>
	<c:when test="${membersList == null }">
		<tr align='center'>
			<td colspan='5'><b>등록된 회원이 없습니다.</b></td>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var='mem' items="${membersList}">
			<tr align='center'>
				<td width='7%'><b>${mem.id }</b></td>
				<td width='7%'><b>${mem.pw }</b></td>
				<td width='7%'><b>${mem.name }</b></td>
				<td width='7%'><b>${mem.email }</b></td>
				<td width='7%'><b>${mem.joinDate }</b></td>
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>
	</table>
</body>
</html>