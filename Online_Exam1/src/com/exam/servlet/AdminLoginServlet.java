package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.jdbc.JDBC;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userid");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		try {
			if (JDBC.checkAdminLogin(username, password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", username);
				RequestDispatcher rd = request
						.getRequestDispatcher("adminprofile.jsp");
				rd.forward(request, response);
			} else {
				String message = "OOps!!! Invalid Username/Password";
				request.setAttribute("message", message);
				request.getRequestDispatcher("admin.jsp").forward(request,
						response);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
