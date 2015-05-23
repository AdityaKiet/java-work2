<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.exam.dto.UserDTO , com.exam.listener.SessionCountListener"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<link rel="stylesheet" href="css1/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Profile !!</title>
</head>

<body>
	Welcome
	<%=session.getAttribute("user")%>
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
			<caption>Your details are : -</caption>
			<thead>
				<tr>
					<th>Category</th>
					<th>Value</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Name :</td>
					<td><%=userDTO.getName()%></td>

				</tr>
				<tr>
					<td>E-mail :</td>
					<td><%=userDTO.getEmail()%></td>

				</tr>
				<tr>
					<td>Age :</td>
					<td><%=userDTO.getAge()%></td>
				</tr>
				<tr>
					<td>User Name :</td>
					<td><%=userDTO.getUserid()%></td>

				</tr>

			</tbody>
		</table>
	</div>
	<br></br>
	<br></br>
	<br></br>
	<div id="container">
		<table class="zebra">
			<CAPTION>Choose any one !!!</CAPTION>
			<thead>
				<tr>
					<th>Category</th>
					<th>Value</th>

				</tr>
			</thead>
			<TBODY>
				<tr>
					<td>Choose Quiz</td>
					<td><form action="quiz_master">
							<input type="submit" value="Choose Quiz" />
						</form></td>
				</tr>

				<tr>

					<td>Show Results</td>
					<td><form action="allresults">
							<input type="submit" value="My Results" />
						</form></td>
				</tr>
			</TBODY>
		</table>
	</div>
	<div id="footer">
		<%
			out.println("<h2>Total No of Login User "
					+ SessionCountListener.counter);
		%>
	</div>
</body>
</html>