package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.dto.ReportDTO;
import com.canteen.jdbc.JDBC;

/**
 * Servlet implementation class Report
 */
@WebServlet("/report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check[] = request.getParameterValues("check");
		String radio = request.getParameter("radio");
		RequestDispatcher rd = null;
		ArrayList<ReportDTO> reports = null;
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		int month      = calendar.get(Calendar.MONTH); 
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); // Jan = 0, not 1
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		if(check.length==0)
		{
			request.setAttribute("message", "select atleast one parameter...");
			rd = request.getRequestDispatcher("report.jsp");
			rd.forward(request, response);
			return;
		}

		switch (radio) {

		case "1day":
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "2day":
			calendar.set(Calendar.DAY_OF_YEAR, dayOfYear-1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "3day":
			calendar.set(Calendar.DAY_OF_YEAR, dayOfYear-2);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "4day":
			calendar.set(Calendar.DAY_OF_YEAR, dayOfYear-3);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "5day":
			calendar.set(Calendar.DAY_OF_YEAR, dayOfYear-4);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "1week":
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "2week":
			calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear-1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		case "3week":
			calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear-2);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		case "4week":
			calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear-3);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		case "5week":
			calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear-4);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
			
		case "1month":
			calendar.set(Calendar.DAY_OF_MONTH, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			date = calendar.getTime();
			break;
		case "2month":
			calendar.set(Calendar.DAY_OF_MONTH, month-1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		case "3month":
			calendar.set(Calendar.DAY_OF_MONTH, month-2);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		case "4month":
			calendar.set(Calendar.DAY_OF_MONTH, month-3);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		case "5month":
			calendar.set(Calendar.DAY_OF_MONTH, month-4);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DAY_OF_WEEK, 0);
			date = calendar.getTime();
			break;
		}
		
		try {
			reports = JDBC.getReport(date);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		if(null != reports && reports.size() != 0)
		{
			request.setAttribute("items", reports);
			rd = request.getRequestDispatcher("showReport.jsp");
			rd.forward(request, response);
			return;
		}
		else
		{
			request.setAttribute("message", "No any reposrt found in this interval....");
			rd = request.getRequestDispatcher("report.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

}
