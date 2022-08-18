<%@page import="com.gm.start.bankbook.BankBookDAO"%>
<%@page import="com.gm.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//BankBookDTO bankBookDTO = (BankBookDTO) request.getAttribute("dto");
//BankBookDTO bankBookDTO = new BankBookDTO();
//BankBookDAO bankBookDAO = new BankBookDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Page</h2>
	<hr>
	<h4>현재 등록되어 있는 상품</h4>
	<table border="1">
		<tr>
			<th>일련번호</th>
			<th>통장이름</th>
			<th>이자율</th>
			<th>판매여부</th>
		</tr>
<%-- 		<tr>
			<td><%=bankBookDTO.getBookNum()%></td>
			<td><%=bankBookDTO.getBookName()%></td>
			<td><%=bankBookDTO.getBookRate()%></td>
			<td><%=bankBookDTO.getBookSale()%></td>
		</tr> --%>
	</table>
	<br>
	<hr>
	<br>
	<form action="add.gm" method="post">
		<h4>일련번호</h4>
		<input type="text" name="bookNum">
		<h4>통장이름</h4>
		<input type="text" name="bookName">
		<h4>이자율</h4>
		<input type="text" name="bookRate">
		<h4>판매여부</h4>
		<input type="text" name="bookSale" value="1" readonly> <br>
		
		<br> <input type="submit" value="상품등록"> <br>
	</form>
	<a href="../">home</a>
</body>
</html>