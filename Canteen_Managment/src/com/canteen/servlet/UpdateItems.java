package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.dto.ItemDTO;
import com.canteen.jdbc.JDBC;

/**
 * Servlet implementation class UpdateItems
 */
@WebServlet("/update")
public class UpdateItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(Integer.parseInt(request.getParameter("id").toString()));
		itemDTO.setName(request.getParameter("item"));
		itemDTO.setPrice(request.getParameter("amount"));
		RequestDispatcher rd;
		try {
			boolean result = JDBC.updateItem(itemDTO);
			if (result) {
				request.setAttribute("message",
						"Selected Item have been updated");
				request.setAttribute("items", JDBC.getAllItems());
				rd = request.getRequestDispatcher("updateselectitem.jsp");
				rd.forward(request, response);
				return;
			} else {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (ClassNotFoundException | SQLException e) {
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
