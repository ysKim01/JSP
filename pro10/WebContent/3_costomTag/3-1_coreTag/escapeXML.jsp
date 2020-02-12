<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import='java.io.*'
	isELIgnored='false'
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML 변환하기</title>
</head>
<body>
	<c:out value="&lt;" escapeXml='true' /><br>
	<c:out value="&lt;" escapeXml='false' /><br><br>
	
	<c:out value="&amp;" escapeXml='true' /><br>
	<c:out value="&amp;" escapeXml='false' /><br><br>
	
	<c:out value="&034;" escapeXml='true' /><br>
	<c:out value="&034;" escapeXml='false' /><br><br>
	
	<c:out value="&039;" escapeXml='true' /><br>
	<c:out value="&039;" escapeXml='false' /><br><br>
</body>
</html>