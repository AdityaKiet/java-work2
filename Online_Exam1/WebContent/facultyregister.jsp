<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="ducat" tagdir="/WEB-INF/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here !!!</title>
</head>
<body>
	<div id="wrapper">

		<form name="login-form" class="login-form" action="facultyregister"
			method="post">

			<div class="header">
				<h1>Faculty Registration Form</h1>
			</div>
			<ducat:message message="${message}" />
			<div class="content">
				<input name="name" type="text" class="input name" placeholder="Name"
					required="required" />
				<div class="user-icon"></div>
				<input name="age" type="number" class="input age" placeholder="Age"
					required="required" />
				<div class="user-icon"></div>
				<input name="email" type="text" class="input email"
					placeholder="Email" required="required" />
				<div class="user-icon"></div>
				<input name="userid" type="text" class="input username"
					placeholder="User Name" required="required" />
				<div class="user-icon"></div>
				<input name="password" type="password" class="input password"
					placeholder="Password" required="required" />
				<div class="pass-icon"></div>
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="Register" class="button" />
				<div class="pass-icon"></div>
				<input type="reset" name="reset" value="Reset" class="button" />
			</div>
		</form>
	</div>
	<div class="gradient"></div>
</body>
</html>