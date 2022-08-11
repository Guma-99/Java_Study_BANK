<%@page import="com.gm.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--
<%
BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");
%>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail List</h1>
	<hr>
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td>${requestScope.dto.getBooknum()}</td>
			<td>${requestScope.dto.bookname}</td>
			<td>${dto.bookrate}</td>
			<td></td>
		</tr>
	</table>
	<br>
	<a href="./update?booknum=${dto.booknum}">수정</a>
	<a href="./delete?booknum=${dto.booknum}"
		onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
	<hr>
	<a href="./list">List Page</a>

</body>
</html>