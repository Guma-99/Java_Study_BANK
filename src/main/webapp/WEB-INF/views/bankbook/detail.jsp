<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<td>${requestScope.dto.getBookNum()}</td>
			<td>${requestScope.dto.bookName}</td>
			<td>${dto.bookRate}</td>
			<td></td>
		</tr>
	</table>
	<br>
	<a href="./update.gm?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete.gm?bookNum=${dto.bookNum}"
		onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankaccount/add.gm?bookNum=${dto.bookNum}">가입하기</a>
	</c:if>
	<hr>
	<a href="./list.gm">List Page</a>

</body>
</html>