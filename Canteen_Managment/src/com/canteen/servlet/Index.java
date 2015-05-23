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

import com.canteen.dto.FeedbackDTO;
import com.canteen.dto.OrderDTO;
import com.canteen.dto.UserDTO;
import com.canteen.jdbc.JDBC;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		switch (request.getParameter("rqst")) {

		case "Feedback":
			try {
				List<FeedbackDTO> list = JDBC.getFeedback();
				if (list.size() == 0) {
					request.setAttribute("message",
							"No feedbacks found so far.. Please review here again later..");
					rd = request.getRequestDispatcher("feedback.jsp");
					rd.forward(request, response);
					return;
				} else {
					request.setAttribute("feedback", list);
					rd = request.getRequestDispatcher("feedback.jsp");
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
		case "Report":
			rd = request.getRequestDispatcher("report.jsp");
			rd.forward(request, response);
			return;
		case "All Orders":
			try {
				List<OrderDTO> orderList = JDBC.getAllOrders();
				if (orderList.size() == 0) {
				
					request.setAttribute("message",
							"No orders found so far.. Please review here again later..");
					rd = request.getRequestDispatcher("allorders.jsp");
					rd.forward(request, response);
					return;
				} else {
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

		case "Add new Customer":
			rd = request.getRequestDispatcher("addnewuser.jsp");
			rd.forward(request, response);
			return;
		case "Recharge":
			rd = request.getRequestDispatcher("recharge.jsp");
			rd.forward(request, response);
			return;
		case "Available Items":
			/*
			 * try { Date date = new Date(); CloseCanteen mysqlToXls = new
			 * CloseCanteen("canteen_managment", "root", "");
			 * mysqlToXls.generateXls("current_order", date + ".xls");
			 * System.out.println(); mysqlToXls.close(); } catch (Exception e) {
			 * e.printStackTrace(); } try { request.setAttribute("items",
			 * JDBC.getAllItems()); rd =
			 * request.getRequestDispatcher("availableitems.jsp");
			 * rd.forward(request, response); return; } catch
			 * (ClassNotFoundException e) { rd =
			 * request.getRequestDispatcher("error.jsp"); rd.forward(request,
			 * response); return; } catch (SQLException e) { rd =
			 * request.getRequestDispatcher("error.jsp"); rd.forward(request,
			 * response); return; }
			 */
			rd = request.getRequestDispatcher("close");
			rd.forward(request, response);
			return;
		case "Add New Item":
			rd = request.getRequestDispatcher("addItem.jsp");
			rd.forward(request, response);
			return;
		case "Delete an Item":
			try {
				request.setAttribute("items", JDBC.getAllItems());
				rd = request.getRequestDispatcher("deleteitem.jsp");
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
		case "Delete customer":
			try {
				System.out.println("delete customers");
				List<UserDTO> users = JDBC.getAllUsers();
				if (users.size() == 0) {
					request.setAttribute("message",
							"No users found so far.. Please review here again later..");
					rd = request.getRequestDispatcher("errorpage.jsp");
					rd.forward(request, response);
					return;
				} else {
					request.setAttribute("users", users);
					rd = request.getRequestDispatcher("deletecustomer.jsp");
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
		case "Change Availability":
			try {
				request.setAttribute("items", JDBC.getAllItems());
				rd = request.getRequestDispatcher("updateavailableitems.jsp");
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
		case "Update an Item":
			try {
				request.setAttribute("items", JDBC.getAllItems());
				rd = request.getRequestDispatcher("updateselectitem.jsp");
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
