package com.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.jdbc.JDBC;

public class FacultyConfirmDeleteQuiz extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user");
			String quiz_id = request.getParameter("quiz_id");
			PrintWriter out = response.getWriter();
			if (JDBC.deleteQuiz(quiz_id, userid)) {
				out.println("Successfully Deleted");
			} else {
				out.println("Not Deleted SomeError on server");
			}
		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		} catch (NullPointerException e) {
			RequestDispatcher rd = request
					.getRequestDispatcher("noneselected.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
