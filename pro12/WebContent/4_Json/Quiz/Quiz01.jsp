<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			var jsonStr='[' +
				'{"name":"박지성","age":32,"blood":"B"},' +
				'{"name":"이몽룡","age":30,"blood":"A"},' +
				'{"name":"이순신","age":23,"blood":"AB"}]';
			var jsonObj = JSON.parse(jsonStr);
			var output = "회원 정보<br>";
			output+= "#################<br>";
			for(var i in jsonObj){
				output+= "이름 : "+jsonObj[i].name+"<br>";
				output+= "나이 : "+jsonObj[i].age+"<br>";
				output+= "혈액형 : "+jsonObj[i].blood+"<br><br>";
			}
			$("#output").html(output);
		})
	})
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a>
	<br><br>
	<div id="output"></div>
</body>
</html>