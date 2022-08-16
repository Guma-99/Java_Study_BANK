<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
body {
	background-image: url('../resources/images/DDDDDD.jpg');
	background-repeat: no-repeat;
	background-position: center center;
}
</style>
<title>Home</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Hello world!</h1>
	</div>
	<hr>

	<div style="text-align: center">
		<P>The time on the server is ${serverTime}.</P>
		<%-- 다 같은 뜻 == / eq / empty --%>
		<c:if test="${empty sessionScope.member}">
			<a href="./member/login.gm">Login</a>
			<a href="./member/join.gm">Join</a>
		</c:if>
		<c:if test="${not empty sessionScope.member}">
			<h3>${sessionScope.member.name}님환영합니다.</h3>
			<a href="./member/logout.gm">logout</a>
			<a href="#">Mypage</a>
		</c:if>
		<a href="./bankbook/list.gm">List</a> <a href="./bankbook/detail.gm">Detail</a>
		<a href="./bankbook/add.gm">add</a> <a href="./member/search.gm">search</a>
		<a href="./bankbook/update.gm">update</a>
	</div>

	<%--
	<br>
	<img src=../resources/images/DD.jpg>
	<img src=../resources/images/DDD.jpg>
	<img src=../resources/images/DDDD.jpg>
	<br>
	<img src=../resources/images/DDDDD.jpg>
	<img src=../resources/images/DDDDDD.jpg>
	 --%>
</body>
</html>
