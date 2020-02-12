<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored='false' 
    import='sec01.ex02.*' %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id='m' class='sec01.ex02.MemberVO' />
<jsp:setProperty name='m' property='*' />
<jsp:useBean id='addr' class='sec01.ex02.address' />
<jsp:setProperty name='addr' property='city' value='서울' />
<jsp:setProperty name='addr' property='zipcode' value='09876' />
<%
	m.setAddr(addr);
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
			<td width='10%'>아이디</td>
			<td width='10%'>비밀번호</td>
			<td width='10%'>이름</td>
			<td width='10%'>이메일</td>
			<td width='10%'>도시</td>
			<td width='10%'>우편번호</td>
		</tr>
		<tr align='center'>
			<td>${m.id }</td>
			<td>${m.pwd }</td>
			<td>${m.name }</td>
			<td>${m.email }</td>
			<td><%=m.getAddr().getCity() %></td>
			<td><%=m.getAddr().getZipcode() %></td>
		</tr>
		<tr align='center'>
			<td>${m.id }</td>
			<td>${m.pwd }</td>
			<td>${m.name }</td>
			<td>${m.email }</td>
			<td>${m.addr.city }</td>
			<td>${m.addr.zipcode }</td>
		</tr>
	</table>
</body>
</html>













