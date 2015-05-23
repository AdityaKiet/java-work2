<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="ducat" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="css1/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete questions here</title>
</head>
<body>

	<%
		String quiz_id = request.getParameter("quiz_id");
		if (quiz_id != null)
			session.setAttribute("quiz_id", quiz_id);
	%>
	<ducat:message message="${message}" />
	<form action="facutltyDeleteQuestions" method="post">
		<div id="container">
			<table class="zebra">
				<caption>Select any question !!</caption>
				<thead>
					<tr>
						<th>Question</th>
					</tr>
				</thead>
				<c:forEach items="${questionData}" var="x">

					<tr>
						<td>${x.question}</td>
						<td><input type="radio" name="question" value="${x.question}">
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