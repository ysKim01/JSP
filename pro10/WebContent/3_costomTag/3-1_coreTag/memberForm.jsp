<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action='member9.jsp'>
		<h1 style='text-align:center'>회원가입창</h1>
		<table align='center'>
			<tr>
				<td width='200'> <p align='right'> 아이디</p> </td>
				<td width='400'> <input type='text' name='id'> </td>
			</tr>
			<tr>
				<td width='200'> <p align='right'> 패스워드</p> </td>
				<td width='400'> <input type='password' name='pw'> </td>
			</tr>
			<tr>
				<td width='200'> <p align='right'> 이름</p> </td>
				<td width='400'> <input type='text' name='name'> </td>
			</tr>
			<tr>
				<td width='200'> <p align='right'> 이메일</p> </td>
				<td width='400'> <input type='text' name='email'> </td>
			</tr>
		</table>
		<input type='submit' value='전송' >
		<input type='reset' value='다시입력'>
	</form>
</body>
</html>