<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored='false' 
    import='sec01.ex01.*' %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id='m' class='sec01.ex01.MemberVO' />
<jsp:setProperty name='m' property='*' />
<jsp:useBean id="membersList" class="java.util.ArrayList" />
<%
	MemberVO m1 = new MemberVO("son","1234","손흥민","son@test.com");
	membersList.add(m);
	membersList.add(m1);
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
			<td>${membersList[0].id }</td>
			<td>${membersList[0].pwd }</td>
			<td>${membersList[0].name }</td>
			<td>${membersList[0].email }</td>
		</tr>
		<tr align='center'>
			<td>${membersList[1].id }</td>
			<td>${membersList[1].pwd }</td>
			<td>${membersList[1].name }</td>
			<td>${membersList[1].email }</td>
		</tr>
	</table>
</body>
</html>













