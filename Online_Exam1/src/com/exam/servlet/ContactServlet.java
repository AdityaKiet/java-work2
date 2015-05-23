package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dto.QueryDto;
import com.exam.jdbc.JDBC;

public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		QueryDto queryDTO = new QueryDto();
		queryDTO.setName(request.getParameter("name"));
		queryDTO.setPhone(request.getParameter("phone"));
		queryDTO.setEmail(request.getParameter("email"));
		queryDTO.setQuery(request.getParameter("query"));
		try {
			if (JDBC.submitQuery(queryDTO)) {
				String message = "Query Submitted";
				request.setAttribute("message", message);
				request.getRequestDispatcher("contact.jsp").forward(request,
						response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
