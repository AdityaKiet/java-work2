<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="ducat" tagdir="/WEB-INF/tags"%>
<html>

<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Login !!!!</title>
</head>
<body>


	<div id="wrapper">

		<form name="login-form" class="login-form" action="FacultyLogin"
			method="post">

			<div class="header">
				<h1>Login Form</h1>
			</div>
			<ducat:message message="${message}" />
			<div class="content">
				<input name="userid" type="text" class="input username"
					placeholder="User Name" required="required" />
				<div class="user-icon"></div>
				<input name="password" type="password" class="input password"
					placeholder="Password" required="required" />
				<div class="pass-icon"></div>
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="Login" class="button" />
		</form>
		<form action="facultyregister.jsp">
			<input type="submit" name="submit" value="Register" class="register" />
		</form>
	</div>
	</div>
	<div class="gradient"></div>



</body>
</html>