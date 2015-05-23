<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="quiz_id"%>
<%@attribute name="session"%>
<%
	if (quiz_id != null)
		session.setAttribute("quiz_id", quiz_id);
%>