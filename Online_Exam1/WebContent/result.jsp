<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.exam.dto.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css1/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
	Welcome
	<%=session.getAttribute("user")%>!!!
	<br></br>
	<%
		UserDTO userDTO = (UserDTO) request.getAttribute("userDTO");
	%>
	<div id="header">
		<form name="logout-form" class="logout-form" action="logout"
			style="float: right;" method="post">
			<input type="submit" name="Logout" value="LogOut" class="button" />
		</form>
	</div>
	<div id="container">
		<table class="zebra">
			<caption>Your previous results are ...</caption>
			<thead>
				<tr>
					<th>Quiz Id</th>
					<th>Quiz Name</th>
					<th>Score</th>
				</tr>
			</thead>
			<c:forEach items="${resultData}" var="x">

				<tr>
					<td>${x.quiz_id}</td>

					<td>${x.quiz_name}</td>
					<td>${x.score}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>