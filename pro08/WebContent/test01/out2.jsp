<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = (String)request.getParameter("name");
	String address = (String)request.getParameter("address");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>none</title>
</head>
<body>
<%	
	if(name!=null || name.length()!=0){	
 		out.print(name+", "+address); 
	}else { 
		out.print("이름을 입력하세요.");
	}	
%>
</body>
</html>