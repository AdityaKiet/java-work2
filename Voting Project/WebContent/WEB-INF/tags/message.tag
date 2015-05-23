<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="message"%>
<%
	if (!message.equals("") && message != null
			&& !message.equals("null"))
		out.println(request.getAttribute("message"));
	else
		out.println("");
%>