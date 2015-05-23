package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dto.QuestionDTO;
import com.exam.jdbc.JDBC;

public class FacultyDeleteQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String quiz_id = (String) session.getAttribute("quiz_id");
		String question = request.getParameter("question");
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setQuiz_id(quiz_id);
		questionDTO.setQuestion(question);
		try {
			if (JDBC.deleteQuestion(questionDTO)) {
				request.setAttribute("message", "Deleted");
				request.getRequestDispatcher("facultydeletequestion.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("message", "Not Deleted");
				request.getRequestDispatcher("facultydeletequestion.jsp")
						.forward(request, response);
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}

}
