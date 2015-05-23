package com.voting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.jdbc.JDBC;

@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		try {
			boolean isValid = JDBC.checkAdminLogin(request.getParameter("id")
					.toString().trim(), request.getParameter("password")
					.toString().trim());
			if (isValid) {
				HttpSession session = request.getSession(true);
				session.setAttribute("adminId", request.getParameter("id"));
				request.setAttribute("posts", JDBC.getFeedback());
				rd = request.getRequestDispatcher("adminprofile.jsp");
				rd.forward(request, response);
				return;
			} else {
				PrintWriter out = response.getWriter();
				out.print("Login Failed.. Login again with correct data");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "database error occured");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;

		}
	}

}
