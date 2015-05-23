package com.mittal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String userid = (String) session.getAttribute("userid");
		PrintWriter out = response.getWriter();
		String design = " <!DOCTYPE html> " + " <html> " + " <head> "
				+ "	<meta charset='UTF-8'>  "
				+ "	<title>Insert title here</title> " + " </head> "
				+ " <h1>Welcome " + userid + "</h1> " + " </body> " + "</html>";
		out.println(design);
		out.close();

	}

}
