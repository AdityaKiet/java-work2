package com.voting.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voting.dto.EmpDTO;
import com.voting.jdbc.JDBC;

/**
 * Servlet implementation class AdminAction
 */
@WebServlet("/AdminAction")
public class AdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isDone;
		EmpDTO dto = new EmpDTO();
		RequestDispatcher rd;
		dto.setId(request.getParameter("id"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setDesignation(request.getParameter("designation"));
		dto.setPhoneno(request.getParameter("phone"));
		System.out.println(dto);
		try {
			isDone = JDBC.addEmployee(dto);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		if (isDone) {
			System.out.println("Done");
		} else {
			System.out.println("Not Done");
		}		
	}

}
