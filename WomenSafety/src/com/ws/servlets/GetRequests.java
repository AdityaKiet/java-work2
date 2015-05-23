package com.ws.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.ws.db.JDBC;
import com.ws.dto.PaginationDTO;
import com.ws.dto.RequestDTO;

/**
 * Servlet implementation class GetRequests
 */
@WebServlet("/GetRequests")
public class GetRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER  =  LoggerFactory.getLogger(GetRequests.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static int totalRecords;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int startRow = Integer.parseInt(request.getParameter("iDisplayStart"));
		int noofRecords=Integer.parseInt(request.getParameter("iDisplayLength"));
		int echo = Integer.parseInt(request.getParameter("sEcho"));
		String search = request.getParameter("sSearch");
		
		
		PrintWriter out=response.getWriter();
		Gson gson = new Gson();
		String jsonString=null;

		List<RequestDTO> requestList = null;
		
		try{
			requestList = JDBC.getRequests(search, startRow, noofRecords, echo);
			PaginationDTO paginationDTO = new PaginationDTO();
			paginationDTO.setsEcho(echo);
			paginationDTO.setAaData(requestList);
			paginationDTO.setiTotalDisplayRecords(totalRecords);
			paginationDTO.setiTotalRecords(totalRecords);
			jsonString = gson.toJson(paginationDTO);
		} catch (ClassNotFoundException | SQLException e) {			
			LOGGER.error(e.getMessage(), e);
		}finally{
			out.println(jsonString);
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		return;
	}

}
