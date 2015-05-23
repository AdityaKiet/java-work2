<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selected Candidates</title>
<link href="result.css" rel="stylesheet">
</head>
<body>
<table cellspacing='0'>
	<tr>
	<th>Id</th><th>Name</th><th>Number</th><th>area</th><th>Skills</th>
	</tr>
    

<c:forEach items="${results }" var="result" varStatus="loop">
<tr>
				<td><c:out value="${result.id}"></c:out></td>
				<td><c:out value="${result.name}"></c:out></td>
				<td><c:out value="${result.number}"></c:out></td>
				<td><c:out value="${result.area}"></c:out></td>
				<td>
				<c:forEach items="${result.skills }" var="resultSkills">
				<c:out value="${resultSkills}"></c:out> ,
				</c:forEach>
				</td>
				
				
</tr></c:forEach>


	
</table>
</body>
</html>
