package com.ws.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ws.db.JDBC;
import com.ws.dto.AdminDTO;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminLogin.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String adminId = request.getParameter("adminId").trim();
			String password = request.getParameter("password").trim();
			
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setAdminId(adminId);
			adminDTO.setPassword(password);
			
			boolean check = JDBC.checkAdminLogin(adminDTO);
			if(check){
				HttpSession session = request.getSession(true);
				session.setAttribute("id", adminId);
				response.sendRedirect("home.jsp");
			}else{
				request.setAttribute("attempt", "false");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
	}

}
