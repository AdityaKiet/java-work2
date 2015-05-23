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
 * Servlet implementation class UpdateSelectItem
 */
@WebServlet("/selectupdateitem")
public class UpdateSelectItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id;
		RequestDispatcher rd;
		String idString = request.getParameter("selecteditem");
		if (null == idString) {
			request.setAttribute("message", "select an item to update ... ");
			try {
				request.setAttribute("items", JDBC.getAllItems());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("updateselectitem.jsp");
			rd.forward(request, response);
			return;
		} else {
			id = Integer.parseInt(idString);

			ItemDTO itemDTO = new ItemDTO();
			try {
				itemDTO = JDBC.getItemDetail(id);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("id", itemDTO.getId());
			request.setAttribute("name", itemDTO.getName());
			request.setAttribute("price", itemDTO.getPrice());
			rd = request.getRequestDispatcher("updateitem.jsp");
			rd.forward(request, response);
		}
	}
}
