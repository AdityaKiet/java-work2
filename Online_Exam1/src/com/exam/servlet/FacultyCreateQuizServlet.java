package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dto.QuizMasterDTO;
import com.exam.jdbc.JDBC;

public class FacultyCreateQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String quizname = request.getParameter("quizname");
		try {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user");
			System.out.println(userid);
			if (!JDBC.isQuizExists(quizname)) {
				QuizMasterDTO quizMasterDTO = new QuizMasterDTO();
				quizMasterDTO = JDBC.createquiz(quizname);
				JDBC.facultyQuiz(userid, quizMasterDTO.getQuiz_id(),
						quizMasterDTO.getQuiz_name());
				String message = "Quiz " + quizMasterDTO.getQuiz_name()
						+ " with QuizID " + quizMasterDTO.getQuiz_id()
						+ " has been successfully created.";
				request.setAttribute("message", message);
				request.getRequestDispatcher("facultynewquiz.jsp").forward(
						request, response);
			} else {
				String message = "Quiz Name Already exists!!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("facultynewquiz.jsp").forward(
						request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
