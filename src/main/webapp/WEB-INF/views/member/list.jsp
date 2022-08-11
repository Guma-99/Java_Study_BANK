<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	<table border="1">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
		</thead>
		<tbody>
			<c:forEach begin="0" end="10" var="i" step="2">
				<h3>${pageScope.i}</h3>
			</c:forEach>

			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.username}</td>
					<td>${pageScope.dto.name}</td>
					<td>${pageScope.dto.email}</td>
					<td>${pageScope.dto.phone}</td>
				</tr>
			</c:forEach>

			<%-- <%
			for (BankMembersDTO bDto : ar) {
			%>
			<tr>
				<td><%=bDto.getUsername()%></td>
				<td><%=bDto.getName()%></td>
				<td><%=bDto.getEmail()%></td>
				<td><%=bDto.getPhone()%></td>
			</tr>
			<%
			}
			%> --%>
		</tbody>

	</table>

</body>
</html>