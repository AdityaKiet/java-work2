package com.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dto.AnswerDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ResultDTO;
import com.exam.jdbc.JDBC;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int pages = -1;
	private static List<QuestionDTO> questionList;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<AnswerDTO> answerList = new ArrayList<>();
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user");
			String quiz_id = request.getParameter("quiz_id");
			ResultDTO resultDTO = new ResultDTO();
			resultDTO.setQuiz_id(quiz_id);
			resultDTO.setUserid(userid);
			if (!JDBC.alreadyAttempted(resultDTO)) {

				if (pages == -1) {

					questionList = JDBC.foundQuestion(quiz_id);
					session.setAttribute("totalQuestion", questionList.size());
					session.setAttribute("questionData", questionList);
					request.setAttribute("questionData", questionList);
				}
				if (pages == 0) {
					for (int counter = 1; counter <= 10; counter++) {

						AnswerDTO answerDTO = new AnswerDTO();
						answerDTO.setQuestion_id(questionList.get(counter - 1)
								.getQuestion_id());
						answerDTO.setQuestion(questionList.get(counter - 1)
								.getQuestion());
						answerDTO.setOption1(questionList.get(counter - 1)
								.getOption1());
						answerDTO.setOption2(questionList.get(counter - 1)
								.getOption2());
						answerDTO.setOption3(questionList.get(counter - 1)
								.getOption3());
						answerDTO.setOption4(questionList.get(counter - 1)
								.getOption4());
						answerDTO.setAnswer(questionList.get(counter - 1)
								.getAnswer());
						answerDTO.setSelected(request.getParameter(Integer
								.toString(counter)));
						answerList.add(answerDTO);
					}
					for (int index = 0; index < 10; index++)
						questionList.remove(index);
				}
				pages++;
				RequestDispatcher rd = request
						.getRequestDispatcher("question.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("message", "Already Attempted");
				RequestDispatcher rd = request
						.getRequestDispatcher("alreadyattempetd.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		} catch (NullPointerException e) {
			RequestDispatcher rd = request
					.getRequestDispatcher("noneselected.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}

	}
}
