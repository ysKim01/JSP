<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"
	import ='java.util.*, sec01.ex01.*'    
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id='membersList' class='java.util.ArrayList' />
<jsp:useBean id='membersMap' class='java.util.HashMap' />
<%
	membersMap.put("id", "park2");
	membersMap.put("pw", "1234");
	membersMap.put("name", "박지성");
	membersMap.put("email", "park2@na.com");
	
	MemberVO m1 = new MemberVO("son", "1234", "손흥민", "son@kg.com");
	MemberVO m2 = new MemberVO("kim", "1234", "김영상", "kim@kg.com");
	
	membersList.add(m1);
	membersList.add(m2);
	membersMap.put("membersList", membersList);
	
%>
<c:set var="ml" value="${membersMap.membersList}" />

<c:set var='id' value='hong' scope='page'/>
<c:set var='pw' value='1234' scope='page'/>
<c:set var='name' value="${'홍길동' }" scope='page'/>
<c:set var='age' value='22' scope='page'/>
<c:set var='height' value='177' scope='page'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력 창</title>
</head>
<body>
	<table align='center' border='1'>
		<tr align='center' bgcolor='lightgreen'>
			<td width='10%'><b>아이디</b></td>
			<td width='10%'><b>패스워드</b></td>
			<td width='10%'><b>이름</b></td>
			<td width='10%'><b>나이</b></td>
			<td width='10%'><b>키</b></td>
		</tr>
		<tr align='center'>
			<td width='10%'>${ml[0].id }</td>
			<td width='10%'>${ml[0].pw }</td>
			<td width='10%'>${ml[0].name }</td>
			<td width='10%'>${ml[0].email }</td>
			<td width='10%'>${height }</td>
		</tr>
	</table>
	
</body>
</html>