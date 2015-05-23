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
 * Servlet implementation class DeleteItem
 */
@WebServlet("/deleteitem")
public class DeleteItem extends HttpServlet {
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
			request.setAttribute("message","You don't have selected....");
			try {
				request.setAttribute("items", JDBC.getAllItems());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("deleteitem.jsp");
			rd.forward(request, response);
		} else {
			try {
				boolean isDone = JDBC.deleteItems(chcString);
				if (isDone) {
					request.setAttribute("message","Selected Items have been deleted....");
					try {
						request.setAttribute("items", JDBC.getAllItems());
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rd = request.getRequestDispatcher("deleteitem.jsp");
					rd.forward(request, response);
					return;
				} else {
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					return;
				}
			} catch (ClassNotFoundException e) {
				System.out.println(1);
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				System.out.println(2);
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
		}
	}

}
