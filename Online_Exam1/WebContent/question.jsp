<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>
</head>
<body>
	<%
		int counter = 0;
	%>
	<form action="result" method="get">

		<c:forEach items="${questionData}" var="x">
			<%
				if (counter >= 10)
						break;
			%>
			<table border="1">
				<tr>
					<td>${x.question_id}</td>
					<td>${x.question}</td>
				</tr>
				<tr>
					<td><input type="radio" name="${x.question_id}"
						value="${x.option1}"></td>
					<td>${x.option1}</td>
				</tr>
				<tr>
					<td><input type="radio" name="${x.question_id}"
						value="${x.option2}"></td>
					<td>${x.option2}</td>
				</tr>
				<tr>
					<td><input type="radio" name="${x.question_id}"
						value="${x.option3}"></td>
					<td>${x.option3}</td>
				</tr>
				<tr>
					<td><input type="radio" name="${x.question_id}"
						value="${x.option4}"></td>
					<td>${x.option4}</td>
				</tr>
				<%
					counter++;
				%>
			</table>
		</c:forEach>
		<table>
			<tr>

				<td><input type="submit" value="Ok"></td>
			</tr>
		</table>
	</form>
	<%
		if (counter >= 10) {
	%>
	<input type="submit" value="Next" onclick="question" />
	<%
		}
	%>
</body>
</html>