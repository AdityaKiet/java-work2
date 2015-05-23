package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.dto.OrderDTO;
import com.canteen.jdbc.JDBC;

/**
 * 
 * @author aditya
 *
 */
@WebServlet("/order")
public class CurrentOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("order").equals("Refresh")) {
			RequestDispatcher rd;
			try {
				List<OrderDTO> orderList = JDBC.getAllOrders();
				if (orderList.size() == 0) {
					request.setAttribute("message",
							"No orders found so far.. Please review here again later..");
					rd = request.getRequestDispatcher("allorders.jsp");
					rd.forward(request, response);
					return;
				} else {

					// request.setAttribute("ids", request.getParameter("ids"));
					request.setAttribute("orders", orderList);
					rd = request.getRequestDispatcher("allorders.jsp");
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
		} else if (request.getParameter("order").equals("Handle Orders")) {
			String[] chcString = request.getParameterValues("delete");
			RequestDispatcher rd;
			if (chcString == null || chcString.length == 0) {
				List<OrderDTO> orderList = null;
				try {
					orderList = JDBC.getAllOrders();
				} catch (ClassNotFoundException | SQLException e) {
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					return;
				}
				request.setAttribute("message",
						"You don't have any order to update..");
				request.setAttribute("orders", orderList);
				rd = request.getRequestDispatcher("allorders.jsp");
				rd.forward(request, response);
				return;
			} else {
				try {
					ArrayList<String> delay = new ArrayList<>();
					for (String g : chcString) {
						delay.add(request.getParameter(g));
					}
					String[] array = delay.toArray(new String[delay.size()]);
					for (String t : chcString) {
						System.out.println(t);
					}
					for (String t : chcString) {
						System.out.println(request.getParameter(t) + "a");
					}
					boolean isDone = JDBC.confirmOrder(chcString, array);

					if (isDone) {
						request.setAttribute("message",
								"Orders have been confirmed");
						rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
						return;
					} else {
						System.out.println("problem");
						rd = request.getRequestDispatcher("error.jsp");
						rd.forward(request, response);
						return;
					}
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					return;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					return;
				}
			}
		}
	}
}
