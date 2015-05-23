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

/**
 * 
 * @author aditya
 *
 */
@WebServlet("/recharge")
public class Recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("account_number")
				+ request.getParameter("balance"));
		RequestDispatcher rd;
		try {
			boolean isDone = JDBC.recharge(
					request.getParameter("account_number").trim(),
					Double.parseDouble(request.getParameter("balance")));
			if (isDone) {
				request.setAttribute("message", "Recharge Successful !!");
				rd = request.getRequestDispatcher("recharge.jsp");
				rd.forward(request, response);
				return;
			} else {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (NumberFormatException e) {
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		} catch (ClassNotFoundException e) {
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			request.setAttribute("message","Wrong account number... Please check your account number and try again...");
			rd = request.getRequestDispatcher("recharge.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
