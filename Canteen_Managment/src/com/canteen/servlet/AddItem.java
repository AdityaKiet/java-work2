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
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/newitem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		try {
			boolean isDone = JDBC.addNewItem(request.getParameter("item")
					.toString().trim(), request.getParameter("amount")
					.toString().trim());
			System.out.println(isDone);
			if (isDone) {
				request.setAttribute("message",
						"Item has been added successfully !!!");
				rd = request.getRequestDispatcher("addItem.jsp");
				rd.forward(request, response);
				return;
			} else {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println(1);
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		} catch (ClassNotFoundException e) {
			System.out.println(2);
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			System.out.println(3);
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
