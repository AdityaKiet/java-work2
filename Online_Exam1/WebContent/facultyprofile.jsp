<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Faculty</title>
</head>
<body>
	<H2>Welcome !!!!</H2>
	<div id="wrapper">

		<form name="login-form" class="login-form" action="facultynewquiz.jsp"
			method="post">
			<div class="footer">
				<input type="submit" name="submit" value="Create a New Quiz"
					class="button" />
			</div>
		</form>
		<form name="login-form" class="login-form" action="facultydeleteQuiz"
			method="post">
			<div class="footer">
				<input type="submit" name="submit" value="Delete a Quiz"
					class="button" />
			</div>
		</form>
		<form name="login-form" class="login-form"
			action="facultyInsertQuestionSelectQuiz" method="post">
			<div class="footer">
				<input type="submit" name="submit"
					value="Insert Questions in a Quiz" class="button" />
			</div>
		</form>
		<form name="login-form" class="login-form"
			action="facultyDeleteQuestionSelectQuiz" method="post">
			<div class="footer">
				<input type="submit" name="submit"
					value="Delete Questions from a Quiz" class="button" />
			</div>
		</form>
	</div>
</body>
</html>