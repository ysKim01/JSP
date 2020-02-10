<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 창</title>
</head>
<body>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	if(user_id==null || user_id.length()==0){
		RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
		dispatch.forward(request, response);
	}else{
		out.print("<h1>환영합니다."+ user_id +"님!!");
		// out이 미리 선언되어있다.
	}
%>
</body>
</html>