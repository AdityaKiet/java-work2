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

@WebServlet("/currentmenu")
public class AvailableItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] chcString = request.getParameterValues("update");
		RequestDispatcher rd;
		try {
			boolean isDone = JDBC.updateAvailableItems(chcString);
			if (isDone) {
				request.setAttribute("message",
						"Items availability has been changed sucessfully! !!!");
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
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
