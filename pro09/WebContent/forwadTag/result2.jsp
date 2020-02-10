<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
   String msg = "아이디를 입력하지 않았습니다. 다시 입력 하세요.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<%
   String user_id = request.getParameter("user_id");
   if(user_id.length() ==0){
      /* RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
      dispatch.forward(request, response); */
%>
      <jsp:forward page="login2.jsp">
         <jsp:param value="<%=msg %>" name="msg"/>
      </jsp:forward>
<%
   } else {
%>
      <h1>환영합니다. <%=user_id %> 님!!</h1>
<%
   }
%>
</body>
</html>










