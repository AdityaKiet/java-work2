package com.canteen.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.jdbc.CloseCanteen;
import com.canteen.jdbc.JDBC;

/**
 * Servlet implementation class CloseCantenn
 */
@WebServlet("/close")
public class CloseCantennServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("adity");
		try {
			Date date = new Date();
			CloseCanteen mysqlToXls = new CloseCanteen("canteen_managment",
					"root", "");
			System.out.println(mysqlToXls.toString());
			mysqlToXls.generateXls("current_order",
					"/home/aditya/Desktop/Reports/" + date.toString() + ".xls");
			System.out.println(JDBC.endOfDay());
			mysqlToXls.close();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
