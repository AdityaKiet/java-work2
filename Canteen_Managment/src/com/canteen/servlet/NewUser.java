package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.dto.UserDTO;
import com.canteen.jdbc.JDBC;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * 
 * @author aditya
 *
 */
@WebServlet("/newuser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDTO dto = new UserDTO();
		dto.setAccount_number(request.getParameter("rollno").trim());
		dto.setBalance(Double.parseDouble(request.getParameter("balance")
				.trim()));
		dto.setEmail(request.getParameter("email").trim());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);
		dto.setLast_recharge(currentDate);
		dto.setLogin(false);
		dto.setName(request.getParameter("name").trim());
		dto.setPassword(request.getParameter("password").trim());
		dto.setPhoneno(request.getParameter("phone").trim());
		dto.setRollno(request.getParameter("rollno").trim());
		RequestDispatcher rd;
		try {
			boolean isDone = JDBC.addNewUser(dto);
			if (isDone) {
				request.setAttribute("message", "Customer added sucessfully!!");
				rd = request.getRequestDispatcher("addnewuser.jsp");
				rd.forward(request, response);
				return;
			} else {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;

			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			request.setAttribute("message", "Requested Customer Already Exists...");
			rd = request.getRequestDispatcher("addnewuser.jsp");
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
