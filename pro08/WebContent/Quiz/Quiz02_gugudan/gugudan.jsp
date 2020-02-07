<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	boolean isNumber(String str){
		try{
			Integer.parseInt(str);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
%>
<%
	request.setCharacterEncoding("utf-8");

	boolean inputErr = true;
	String danStr = request.getParameter("dan");
	int dan = 0;
	if(isNumber(danStr)){	// 숫자일 경우
		dan = Integer.parseInt(danStr);
		inputErr = false;
	}else{
		inputErr = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scoreTest.jsp</title>
</head>
<body>
	
<%	if(inputErr){ %>
		<h1>잘못 입력하셨습니다.</h1>
<%	}else { %>
		<h1><%=dan %> 단</h1>
<%		for(int i=1;i<=9;i++){%>
		<%=dan %> * <%=i %> = <%=dan*i %> <br> 		
<%		}%>	
<% 	}%>
	
	<br><a href="gugudan.html">구구단 입력</a>
</body>
</html>