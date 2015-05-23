<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<form name="login-form" class="login-form" action="contactus"
			method="post">

			<div class="header">
				<h3>Submit your Query here...</h3>
			</div>

			<div class="content">
				<input name="name" type="text" class="input name" placeholder="Name"
					required="required" />
				<div class="user-icon"></div>
				<input name="email" type="email" class="input email"
					placeholder="Email" required="required" />
				<div class="user-icon"></div>
				<input name="phone" type="text" class="input phone"
					placeholder="Phone Number" required="required" />
				<div class="user-icon"></div>
				<textarea name="query" class="input query"
					placeholder="Your Query.." required="required"></textarea>
				<div class="pass-icon"></div>
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="Submit" class="button" />
				<div class="pass-icon"></div>
				<input type="reset" name="reset" value="Reset" class="button" />
			</div>
		</form>
	</div>
</body>
</html>