<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Simple Sign Up Form by PremiumFreeibes.eu</title>

<!---------- CSS ------------>
<link rel="stylesheet" type="text/css" href="./css1/style.css">
</head>

<body>

	<!--BEGIN #signup-form -->
	<div id="signup-form">

		<!--BEGIN #subscribe-inner -->
		<div id="signup-inner">

			<div class="clearfix" id="header">

				<img id="signup-icon" src="./images/signup.png" alt="" />

				<h1>
					Sign up to yourCompany.com <br /> FREE Today!
				</h1>


			</div>



			<form id="send" action="AdminAction">

				<p>

					<label for="name"> Employee Id *</label> <input id="name"
						type="text" name="id" value="" required="required" />
				</p>

				<p>
					<label for="company"> Name</label> <input id="company" type="text"
						name="name" value="" required="required" />
				</p>

				<p>

					<label for="email">Email *</label> <input id="email" type="email"
						name="email" value=""required="required" />
				</p>



				<p>

					<label for="phone">Designation</label> <select name="designation">
						<option>Managing Director</option>
						<option>kjsv</option>
					</select>
				</p>

				<p>
					<label for="country">Phone No.</label> <input id="Country"
						type="text" name="phone" value="" required="required"/>
				</p>
				<p>

					<button id="submit" type="submit">Submit</button>
				</p>

			</form>

			<div id="required">
				<p>
					* Required Fields<br /> NOTE: You must activate your account after
					sign up
				</p>
			</div>


		</div>

		<!--END #signup-inner -->
	</div>

	<!--END #signup-form -->
	</div>

</body>
</html>