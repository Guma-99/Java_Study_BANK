<%@page import="com.gm.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>) request.getAttribute("list");
	%>

	<h1>BankBook List</h1>
	<%
	if (ar != null) {
	%>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BankBookDTO bankBookDTO : ar) {
			%>
			<tr>
				<td><a href="./detail?Booknum=<%=bankBookDTO.getBooknum()%>">
						<%=bankBookDTO.getBookname()%></a></td>
				<td><%=bankBookDTO.getBookrate()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	} else {
	%>
	<h3>데이터가 올바르지 않습니다.</h3>
	<%
	}
	%>
	<!-- /bankbook/list -->

	<!-- /bankbook/detail  jsp: detail.jsp -->
	<!-- link 주소는 상대경로 작성 -->

</body>
</html>