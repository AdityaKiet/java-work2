package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dto.QuestionDTO;
import com.exam.jdbc.JDBC;

public class FacultyInsertQuestionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		QuestionDTO questionDTO = new QuestionDTO();
		String quiz_id = (String) session.getAttribute("quiz_id");
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String answer = request.getParameter("answer");
		questionDTO.setQuiz_id(quiz_id);
		questionDTO.setQuestion(question);
		questionDTO.setOption1(option1);
		questionDTO.setOption2(option2);
		questionDTO.setOption3(option3);
		questionDTO.setOption4(option4);
		questionDTO.setAnswer(answer);
		try {
			if (JDBC.insertQuestion(questionDTO)) {
				String message = " Question Inserted Successfully";
				request.setAttribute("message", message);
				request.getRequestDispatcher("facultyinsertquestion.jsp")
						.forward(request, response);
			} else {
				String message = "Some Error Qccured!!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("facultyinsertquestion.jsp")
						.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
