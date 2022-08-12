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
	<form action="./update.gm" method="post">
		<div>
			<h4>일련번호</h4>
			<p>
				<b>${dto.bookNum}</b>
			</p>
			<input type="hidden" name="bookNum" value="${dto.bookNum}">
		</div>
		<div>
			<h4>통장이름</h4>
			<input type="text" name="bookName" value="${dto.bookName}">
		</div>
		<div>
			<h4>이자율</h4>
			<input type="text" name="bookRate" value="${dto.bookRate}">
		</div>
		<br>
		<button type="submit">수정하기</button>
		<br> <br> <a href="./list.gm">돌아가기</a>
		<br>
		<a href="../">home</a>
	</form>
</body>
</html>