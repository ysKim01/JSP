<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"
	import='java.util.*, sec01.ex01.*' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%	request.setCharacterEncoding("utf-8"); %>
<c:set var='contextPath' value='${pageContext.request.contextPath }'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 창</title>
</head>
<body>
	<form name='frmMember' method='post' action='${contextPath}/member/modMember.do'>
		<h1 style='text-align:center'>회원 정보 수정</h1>
		<table align='center'>
			<tr>
				<td width='200'>
					<p align='right'>아이디</p>
				</td>
				<td width='400'>
					<input type='text' name='id_Text' value="${memberInfo.id }" disabled>
					<input type='hidden' name='id' value="${memberInfo.id }">
				</td>
			</tr>
			<tr>
				<td width='200'>
					<p align='right'>패스워드</p>
				</td>
				<td width='400'>
					<input type='text' name='pw' value="${memberInfo.pw }">
				</td>
			</tr>
			<tr>
				<td width='200'>
					<p align='right'>이름</p>
				</td>
				<td width='400'>
					<input type='text' name='name' value="${memberInfo.name }">
				</td>
			</tr>
			<tr>
				<td width='200'>
					<p align='right'>이메일</p>
				</td>
				<td width='400'>
					<input type='text' name='email' value="${memberInfo.email }">
				</td>
			</tr>
			<tr>
				<td width='200'>
					<p>&nbsp;</p>
				</td>
				<td width='400'>
					<input type='submit' value='수정'>
					<input type='reset' value='다시입력'>
				</td>
			</tr>
		</table>
	</form>
</body>