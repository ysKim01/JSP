<%@page import="java.util.*, sec01.ex01.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
	List memberList = new ArrayList();
	memberList.add(new MemberVO("a","a","a","a"));
	memberList.add(new MemberVO("b","b","b","b"));
	memberList.add(new MemberVO("c","c","c","c"));
	
%>
<c:set var="list" value="<%=memberList %>" />
<c:set var="lSize" value="<%=memberList.size() %>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz2-2</title>
</head>
<body>
	<table align='center' border='1'>
		<tr align='center' bgcolor='lightgreen'>
			<td width='10%'><b>아이디</b></td>
			<td width='10%'><b>패스워드</b></td>
			<td width='10%'><b>이름</b></td>
			<td width='10%'><b>이메일</b></td>
		</tr>
		<c:forEach var="m" items="${list }" >
			<tr align='center'>
				<td width='10%'>${m.id }</td>
				<td width='10%'>${m.pw }</td>
				<td width='10%'>${m.name }</td>
				<td width='10%'>${m.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>