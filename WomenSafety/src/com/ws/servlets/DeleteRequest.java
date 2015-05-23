package com.ws.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ws.db.JDBC;

/**
 * Servlet implementation class DeleteRequest
 */
@WebServlet("/DeleteRequest")
public class DeleteRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRequest.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequest() {
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
			Integer id = Integer.parseInt(request.getParameter("id").trim());

			boolean check = JDBC.deleteRequest(id);
			if(check){
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}else{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
		}
	}

}
