<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Update Page</h2>
	<form action="./update" method="post">
		<div>
			<h4>일련번호</h4>
			<p>
				<b>${dto.booknum}</b>
			</p>
			<input type="hidden" name="booknum" value="${dto.booknum }">
		</div>
		<div>
			<h4>통장이름</h4>
			<input type="text" name="bookname" value="${dto.bookname}">
		</div>
		<div>
			<h4>이자율</h4>
			<input type="text" name="bookrate" value="${dto.bookrate}">
		</div>
		<br>
		<button type="submit">수정하기</button>
		<br> <br> <a href="./list">돌아가기</a>
	</form>
</body>
</html>