package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dto.UserDTO;
import com.exam.jdbc.JDBC;

public class FacultyRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(request.getParameter("name"));
		userDTO.setAge(Integer.parseInt(request.getParameter("age")));
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setUserid(request.getParameter("userid"));
		userDTO.setPassword(request.getParameter("password"));

		try {
			if (JDBC.checkFacultyLogin(userDTO.getUserid())) {
				// out.println("User ID already registered");
				String message = "Already Registered";
				request.setAttribute("message", message);
				request.getRequestDispatcher("faculttyregister.jsp").forward(
						request, response);
			} else {
				JDBC.addNewFacultyUser(userDTO);
				String message = "Registered";
				request.setAttribute("message", message);
				request.getRequestDispatcher("facultyregister.jsp").forward(
						request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			e.printStackTrace();
		}

	}

}
