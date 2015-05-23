<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#msg {
	color: red;
}
</style>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if (id != null && password != null) {
			if (id.equals(password)) {
				response.sendRedirect("welcome.jsp");
			} else {
	%>
	<span id="msg">Invalid User Id and password</span>
	<%
		}
		}
	%>
	<form action="login.jsp" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="id" required="required" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required" />
				</td>
			</tr>

		</table>
		<input type="submit" value="Submit" /> 
		<input type="reset" value="Reset" />
	</form>
</body>
</html>