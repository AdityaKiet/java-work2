<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Question here</title>
</head>
<body>

	<%
		String quiz_id = request.getParameter("quiz_id");
		if (quiz_id != null)
			session.setAttribute("quiz_id", quiz_id);
	%>
	<div id="wrapper">

		<form name="login-form" class="login-form"
			action="facultyInsertQuestionServlet" method="post">

			<div class="header">
				<h1>Insert Question</h1>
			</div>
			<div class="content">
				<textarea name="question" class="input name" placeholder="Question"
					required="required"></textarea>
				<input name="option1" type="text" class="input age"
					placeholder="Option 1" required="required" /> <input
					name="option2" type="text" class="input email"
					placeholder="Option 2" required="required" /> <input
					name="option3" type="text" class="input username"
					placeholder="Option 3" required="required" /> <input
					name="option4" type="text" class="input password"
					placeholder="Option 4" required="required" /> <input name="answer"
					type="text" class="input password" placeholder="Answer"
					required="required" />
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="Insert" class="button" />
				<div class="pass-icon"></div>
				<input type="reset" name="reset" value="Reset" class="button" />
			</div>
		</form>
	</div>
</body>
</html>