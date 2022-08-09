<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 | 구디</title>
</head>

<body>
	<h2>GOODEE</h2>
	<form action="./login" method="post">
		<div class="container">
			<input type="text" name="id" placeholder="아이디"> <br>
			<input type="password" name="pw" placeholder="비밀번호">
			<P>
				<input type="checkbox">아이디 저장
			</P>
			<hr>
			<P>
				<input type="submit" value="로그인">
			</P>
		</div>

	</form>
</body>

</html>