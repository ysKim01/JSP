<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import='java.util.*'%>
<%
	int img = 500;
	
	List comName = new ArrayList();
	comName.add("[삼성전자]삼성컴퓨터 SSD 장착 최대 80% 할인");
	comName.add("[삼성전자]삼성 사무용 컴퓨터 i3 i5 듀얼 쿼터코어 PC 모음전");
	comName.add("[LG전자]LG데스크탑 Z71EV-AX7P26 64560 4G SSD 128 윈도우 선택");
	comName.add("빠른 부팅 신품 SSD 넉넉한 저장 공간 DB-Z600 슬림PC");
	
	String[] price = {"199,000","155,000","419,000","299,000"};
	
	String[] company = {"AJ전시몰", "IDC MALL", "Glory MALL", "Microsoft리퍼비셔"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.lst_type{ width : 1000px; }
	#1{ width : 200px; }
	#2{ width : 600px; }
	#3{ width : 100px; }
	#4{ width : 100px; }
	
</style>
</head>
<body>
	<table align='center' class='lst_type'>
		<tr>
			<td>상품이미지</td>
			<td>상품이름</td>
			<td>가격</td>
			<td>판매처</td>
		</tr>
<%		for(int i=0;i<4;i++){%>
		<tr>
			<td id='1'><a href='#'>
			<img src='./image/<%=img+i%>.jpg' width='90' height='90'>
			</a></td>
			<td id='2'><a href='#'><%=comName.get(i) %></a></td>
			<td id='3'><a href='#'><%=price[i] %>원</a></td>
			<td id='2'><a href='#'><%=company[i] %></a></td>
		</tr>	
<%		}%>
	</table>
</body>
</html>