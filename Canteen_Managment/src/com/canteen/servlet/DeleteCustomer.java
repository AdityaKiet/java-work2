package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.dto.UserDTO;
import com.canteen.jdbc.JDBC;

@WebServlet("/deletecustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] chcString = request.getParameterValues("delete");
		RequestDispatcher rd;
		List<UserDTO> users = null;
		try {
			users = JDBC.getAllUsers();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (chcString == null || chcString.length == 0) {
			request.setAttribute("message",
					"You don't have any customers in canteen...");
			request.setAttribute("users", users);
			rd = request.getRequestDispatcher("deletecustomer.jsp");
			rd.forward(request, response);
			return;
		} else {
			try {
				boolean isDone = JDBC.deleteCustomers(chcString);
				if (isDone) {
					request.setAttribute("message",
							"Selected customers have been deleted...");
					request.setAttribute("users", users);
					rd = request.getRequestDispatcher("deletecustomer.jsp");
					rd.forward(request, response);
					return;
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

}
