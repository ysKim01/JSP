<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored='false' import='sec01.ex01.*' %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id='m' class='sec01.ex01.MemberVO' />
<%
	m = (MemberVO)request.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table align='center' width='100%'>
		<tr align='center' bgcolor='#99CCFF'>
			<td width='20%'>아이디</td>
			<td width='20%'>비밀번호</td>
			<td width='20%'>이름</td>
			<td width='20%'>이메일</td>
		</tr>
		<tr align='center'>
			<td><%=m.getId() %></td>
			<td><%=m.getPw() %></td>
			<td><%=m.getName() %></td>
			<td><%=m.getEmail() %></td>
		</tr>
		<tr align='center'>
			<td>${param.member.id }</td>
			<td>${member.pw }</td>
			<td>${member.name }</td>
			<td>${member.email }</td>
		</tr>
	</table>
</body>
</html>













