<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var='contextPath' value='${pageContext.request.contextPath}'/>
<c:url var='url1' value='/3_costomTag/3-1_coreTag/memberOutput.jsp' >
	<c:param name='id' value='hong'/>
	<c:param name='pw' value='1234'/>
	<c:param name='name' value="${'홍길동' }" />
	<c:param name='email' value='22'/>
</c:url>
<!-- c:url은 경로에 get으로 파라미터를 넘기도록 설정할 수있다. -->
<!-- contextPath는 프로젝트까지의 경로 :  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:url 실습</title>
</head>
<body>
	<a href="${url1 }">회원정보출력</a>
	
</body>
</html>