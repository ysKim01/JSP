<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scoreTest.jsp</title>
</head>
<body>
	<h1>시험 점수 <%=score%>점</h1>
<%	if(score>=90){ %>
		<h1>A 학점 입니다.</h1>
<%	}else if(score>=80){ %>
		<h1>B 학점 입니다.</h1>
<%	}else if(score>=70){ %>
		<h1>C 학점 입니다.</h1>
<%	}else if(score>=60){ %>
		<h1>D 학점 입니다.</h1>
<%	}else { %>
		<h1>F 학점 입니다.</h1>
<% 	}%>
	<br><a href="scoreTest.html">시험점수 입력</a>
</body>
</html>