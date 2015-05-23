package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.jdbc.JDBC;

@WebServlet("/feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] chcString = request.getParameterValues("delete");
		RequestDispatcher rd;
		if (chcString == null || chcString.length == 0) {
			request.setAttribute("message","No any Feedback were selected ...");
			rd = request.getRequestDispatcher("feedback.jsp");
			rd.forward(request, response);
		} else {
			try {
				JDBC.deleteFeedbacks(chcString);
				request.setAttribute("message", "Feedbacks have been deleted");
				rd = request.getRequestDispatcher("feedback.jsp");
				rd.forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
		}

	}

}
