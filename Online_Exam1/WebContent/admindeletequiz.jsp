<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css1/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>
</head>
<body>
	Welcome Admin !!!
	<div id="header">
		<form name="logout-form" class="logout-form" action="logout"
			style="float: right;" method="post">
			<input type="submit" name="Logout" value="LogOut" class="button" />
		</form>
	</div>

	<form action="ConfirmDeleteQuiz" method="post">
		<div id="container">
			<table class="zebra">
				<caption>Select any quiz Which you want to Delete!!</caption>
				<thead>
					<tr>
						<th>Quiz Id</th>

						<th>Quiz Name</th>

						<th>Select one</th>
					</tr>
				</thead>
				<c:forEach items="${quizData}" var="x">

					<tr>
						<td>${x.quiz_id}</td>
						<td>${x.quiz_name}</td>
						<td><input type="radio" name="quiz_id" value="${x.quiz_id}">
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td><input type="submit" value="Ok"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>