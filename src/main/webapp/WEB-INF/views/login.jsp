<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="./resources/css/main2.css"/>
<body style="margin: 5% 10% 0 10%">
	<form action="login" method="post">
		<table class="login_page">
			<caption>Login</caption>
			<tr>
				<td>ID</td>
				<td><input type="text" id="ID"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="PWD"/></td>
			</tr>
			<tr class="checkbox">
				<td>
					<input type="checkbox" id="REMEMBERID"/>아이디 기억
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Login" id="Login"/>
					<!-- 회원가입 페이지 넘어가는 용 -->
					<input type="button" value="Register" id="Register"/>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>