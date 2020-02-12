<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<form action="result.jsp">
		아이디 : <input type='text' size=20 /><br>
		암호 : <input type='password' size=20 /><br>
		<input type='submit' value='로그인' />
		<input type='reset' value='다시입력' />
	</form>
	<br><br>
	<!--  <a href="http://localhost:8080/pro10/ImplicitTest/memberForm.html">회원가입 1</a> -->
	<%-- <a href="${pageContext.request.contextPath }/ImplicitTest/memberForm.html">회원가입 2</a> --%>
	<a href="<%=request.getContextPath() %>/ImplicitTest/memberForm.html">회원 가입 3</a>
	</body>
</body>
</html>








