<%@page import="com.gm.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BankBookDTO bankBookDTO = (BankBookDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail List</h1>
	<% if(bankBookDTO != null){ %>
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td><%=bankBookDTO.getBooknum()%></td>
			<td><%=bankBookDTO.getBookname()%></td>
			<td><%=bankBookDTO.getBookrate()%></td>
			<td>
				<%
				if (bankBookDTO.getBooksale() == 1) {
				%> 판매중 <%
				} else {
				%> 품절 <%
				}
				%>
			</td>
		</tr>
	</table>
	<%} else {%>
		<h3>데이터가 올바르지 않습니다.</h3>
	<%} %>

</body>
</html>