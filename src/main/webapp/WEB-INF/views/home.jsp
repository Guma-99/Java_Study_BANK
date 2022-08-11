<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<%-- 다 같은 뜻 == / eq / empty --%>
	<c:if test="${empty member}">
	<a href="./member/login">Login</a>
	<a href="./member/join">Join</a>
	</c:if>
	<c:if test="${not empty member}">
	<a href="#">logout</a>
	<a href="#">Mypage</a>
	</c:if>
	<a href="./bankbook/list">List</a>
	<a href="./bankbook/detail">Detail</a>
	<a href="./bankbook/add">add</a>
	<a href="./member/search">search</a>
	<a href="./bankbook/update">update</a>
	

	<br>
	<img src=../resources/images/DD.jpg>
	<img src=../resources/images/DDD.jpg>
	<img src=../resources/images/DDDD.jpg>
	<br>
	<img src=../resources/images/DDDDD.jpg>
	<img src=../resources/images/DDDDDD.jpg>
</body>
</html>
