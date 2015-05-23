package com.mittal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

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
		RequestDispatcher rd;
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");

		if (userid.equals(password)) {
			System.out.println(userid);
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", userid);
			rd = request.getRequestDispatcher("Welcome.pre");
			rd.forward(request, response);
		}

	}

}
