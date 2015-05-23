<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date" session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome User !!!</title>
</head>
<body bgcolor="cyan"> 
<!-- Instance Variable (init block)-->
<%!int counter = 0; %>
<!-- Local Variable (service block)-->
<%int mycounter = 0;
	  mycounter++;
	  counter++;%>
<h1>Current Date is <%=new Date()%></h1>
<br>
<!-- Printing Scriplet -->
Counter is <%=counter %>
<br>
<!-- Printing Scriplet -->
My counter is <%=mycounter %>
</body>
</html>