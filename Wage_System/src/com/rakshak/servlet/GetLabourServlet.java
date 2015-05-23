package com.rakshak.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakshak.dto.LabourDTO;
import com.rakshak.jdbc.JDBC;

/**
 * Servlet implementation class GetLabourServlet
 */
@WebServlet("/getLabour")
public class GetLabourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("location");
		String startDate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String[] skills = request.getParameterValues("skills");
		List<LabourDTO> labours = new ArrayList<>();
		List<LabourDTO> selectedLabours = new ArrayList<>();
		
		try {
			labours = JDBC.getLabours(startDate, enddate);
			for(LabourDTO labourDTO : labours){
				if(labourDTO.getArea().equals(location)){
					
					boolean done = true;
					
					for(String skill : skills){
						if(!labourDTO.getSkills().contains(skill)){
							done = false;
							break;
						}
					}
					if(done)
						selectedLabours.add(labourDTO);
				}
			}
			request.setAttribute("results", selectedLabours);
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			rd.forward(request, response);
			return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);
			return;
			
		} catch(Exception e){
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);
			return;
		}
		
	}

}
