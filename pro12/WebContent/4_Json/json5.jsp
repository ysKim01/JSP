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
			var _jsonInfo='{"name":"박지성","age":32,"gender":"남자","nickname":"두개의심장"}';
			$.ajax({
				type : "post",
				async : false,
				url : "/pro12/json",
				data : {jsonInfo : _jsonInfo},
				success : function(data, textStatus){
					
				},
				error : function(data, textStatus){
					alert("에러가 발생했습니다.");
				},
				complete : function(data, textStatus){
					alert("작업이 완료되었습니다.");
				}
			});
		});
	});
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a>
	<br><br>
	<div id="output"></div>
</body>
</html>
