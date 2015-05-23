<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="ducat" tagdir="/WEB-INF/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">

		<form name="login-form" class="login-form" action="createquiz"
			method="post">

			<div class="header">
				<h1>Enter a New Quiz Name</h1>
			</div>
			<ducat:message message="${message}" />
			<div class="content">
				<input name="quizname" type="text" class="input username"
					placeholder="Quiz Name" required="required" />
				<div class="user-icon"></div>
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="OK!!" class="button" />
		</form>
	</div>
	</div>
	<div class="gradient"></div>


</body>
</html>