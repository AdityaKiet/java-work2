<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Login</title>
</head>
<body>
<h2>Employee Login</h2>
	<form action="login" method="post">
		<input type="text" placeholder="Employee Id" name="id" required="required"/><br>
		<input type="text" placeholder="Password" name="password" required="required"/><br>
		<input type="submit" value="Login"/>
		<input type="reset" value="Reset"/>
	</form>
</body>
</html>