package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.exam.dto.QueryDto;
import com.exam.dto.QuestionDTO;
import com.exam.dto.QuizMasterDTO;
import com.exam.dto.ResultDTO;
import com.exam.dto.UserDTO;

public class JDBC {

	private static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driverName = rb.getString("drivername");
		Class.forName(driverName);
		System.out.println("Driver Loaded...");
		String url = rb.getString("dburl");
		String userid = rb.getString("userid");
		String password = rb.getString("password");
		Connection con = DriverManager.getConnection(url, userid, password);
		if (con != null) {
			System.out.println("Connection Ready...");
		}
		return con;
	}

	public static UserDTO createProfile(String userid)
			throws ClassNotFoundException, SQLException {
		UserDTO userDTO = new UserDTO();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select * from student_master where userid='"
							+ userid + "'");
			rs.next();
			userDTO.setName(rs.getString("name"));
			userDTO.setAge(rs.getInt("age"));
			userDTO.setEmail(rs.getString("email"));
			userDTO.setUserid(rs.getString("userid"));
			return userDTO;
		}

		finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public static boolean submitQuery(QueryDto queryDTO)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// Step -3 Query
			stmt = con.createStatement();
			PreparedStatement pstmt1 = con
					.prepareStatement("insert into queries (name,email,phone, question) values(?,?,?,?)");
			pstmt1.setString(1, queryDTO.getName());
			pstmt1.setString(2, queryDTO.getEmail());
			pstmt1.setString(3, queryDTO.getPhone());
			pstmt1.setString(4, queryDTO.getQuery());
			int recordCount1 = pstmt1.executeUpdate();
			if (recordCount1 > 0) {
				result = true;
			}
		}

		finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static boolean checkAdminLogin(String userid, String password)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// Step -3 Query
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid,password from adminlogin where userid='"
							+ userid + "' and password='" + password + "'");
			if (rs.next()) {
				result = true;
			}
		}

		finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;

	}

	public static boolean checkfacultyLogin(String userid, String password)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// Step -3 Query
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid,password from facultylogin where userid='"
							+ userid + "' and password='" + password + "'");
			if (rs.next()) {
				result = true;
			}
		}

		finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;

	}

	public static boolean isQuizExists(String quizname)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select quiz_name from quiz_master where quiz_name='"
							+ quizname + "'");
			if (rs.next()) {
				result = true;
			}

		} finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static boolean checkLogin(String userid, String password)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// Step -3 Query
			stmt = con.createStatement();
			// Step -4 Result
			// select userid,password from user where userid='amit' and
			// password='123'
			rs = stmt
					.executeQuery("select userid,password from login where userid='"
							+ userid + "' and password='" + password + "'");
			if (rs.next()) {
				result = true;
				/*
				 * result = "Userid "+ rs.getString("userid")+"  Password "+
				 * rs.getString("password");
				 */
			}
		}

		finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;

	}

	public static String addNewUser(UserDTO userDTO) throws SQLException,
			ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int recordCount1 = 0;
		int recordCount2 = 0;
		String result = "Not Register , Some Error on Server";
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt1 = con
					.prepareStatement("insert into student_master (name,age,email,userid) values(?,?,?,?)");
			pstmt1.setString(1, userDTO.getName());
			pstmt1.setInt(2, userDTO.getAge());
			pstmt1.setString(3, userDTO.getEmail());
			pstmt1.setString(4, userDTO.getUserid());
			recordCount1 = pstmt1.executeUpdate();

			pstmt2 = con
					.prepareStatement("insert into login(userid,password) values(?,?)");
			pstmt2.setString(1, userDTO.getUserid());
			pstmt2.setString(2, userDTO.getPassword());
			recordCount2 = pstmt2.executeUpdate();

			if (recordCount1 > 0 && recordCount2 > 0) {
				result = "Register SuccessFully !";
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (pstmt2 != null) {
				pstmt2.close();
			}
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static String addNewFacultyUser(UserDTO userDTO)
			throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int recordCount1 = 0;
		int recordCount2 = 0;
		String result = "Not Register , Some Error on Server";
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt1 = con
					.prepareStatement("insert into faculty_master (name,age,email,userid) values(?,?,?,?)");
			pstmt1.setString(1, userDTO.getName());
			pstmt1.setInt(2, userDTO.getAge());
			pstmt1.setString(3, userDTO.getEmail());
			pstmt1.setString(4, userDTO.getUserid());
			recordCount1 = pstmt1.executeUpdate();

			pstmt2 = con
					.prepareStatement("insert into facultylogin(userid,password) values(?,?)");
			pstmt2.setString(1, userDTO.getUserid());
			pstmt2.setString(2, userDTO.getPassword());
			recordCount2 = pstmt2.executeUpdate();

			if (recordCount1 > 0 && recordCount2 > 0) {
				result = "Register SuccessFully !";
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (pstmt2 != null) {
				pstmt2.close();
			}
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static List<QuizMasterDTO> foundQuiz()
			throws ClassNotFoundException, SQLException {
		List<QuizMasterDTO> quizList = new ArrayList<QuizMasterDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuizMasterDTO quizDTO = null;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("select quiz_id,quiz_name from quiz_master");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				quizDTO = new QuizMasterDTO();
				quizDTO.setQuiz_id(rs.getString("quiz_id"));
				quizDTO.setQuiz_name(rs.getString("quiz_name"));
				quizList.add(quizDTO);
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return quizList;
	}

	public static List<QuizMasterDTO> foundfacultyQuiz(String username)
			throws ClassNotFoundException, SQLException {
		List<QuizMasterDTO> quizList = new ArrayList<QuizMasterDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuizMasterDTO quizDTO = null;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("select userid , quiz_id,quiz_name from faculty_quiz where userid = '"
							+ username + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				quizDTO = new QuizMasterDTO();
				quizDTO.setQuiz_id(rs.getString("quiz_id"));
				quizDTO.setQuiz_name(rs.getString("quiz_name"));
				quizList.add(quizDTO);
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return quizList;
	}

	public static boolean checkLogin(String userid)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select userid from login where userid='"
					+ userid + "'");
			if (rs.next()) {
				result = true;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static boolean checkFacultyLogin(String userid)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid from facultylogin where userid='"
							+ userid + "'");
			if (rs.next()) {
				result = true;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static List<QuestionDTO> foundQuestion(String quiz_id)
			throws ClassNotFoundException, SQLException {
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		int counter = 0;
		ResultSet rs = null;
		QuestionDTO questionDTO = null;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("select * from question_master where quiz_id = '"
							+ quiz_id + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				counter++;
				questionDTO = new QuestionDTO();
				questionDTO.setQuiz_id(quiz_id);
				questionDTO.setQuestion_id(rs.getString("question_id"));
				questionDTO.setQuestion(rs.getString("question"));
				questionDTO.setOption1(rs.getString("option1"));
				questionDTO.setOption2(rs.getString("option2"));
				questionDTO.setOption3(rs.getString("option3"));
				questionDTO.setOption4(rs.getString("option4"));
				questionDTO.setAnswer(rs.getString("answer"));
				questionList.add(questionDTO);
			}

			questionDTO.setTotalQuestion(counter);

		} finally {

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return questionList;
	}

	public static void loadResult(ResultDTO resultDTO)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		try {
			con = getConnection();
			pstmt1 = con
					.prepareStatement("insert into result_master (userid,quiz_id,result) values(?,?,?)");
			pstmt1.setString(1, resultDTO.getUserid());
			pstmt1.setString(2, resultDTO.getQuiz_id());
			pstmt1.setInt(3, resultDTO.getScore());
			pstmt1.executeUpdate();
		} finally {
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public static boolean alreadyAttempted(ResultDTO resultDTO)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select quiz_id from result_master where quiz_id='"
							+ resultDTO.getQuiz_id()
							+ "' and userid = '"
							+ resultDTO.getUserid() + "'");
			if (rs.next()) {
				result = true;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static List<ResultDTO> showResult(String userid)
			throws ClassNotFoundException, SQLException {
		List<ResultDTO> resultList = new ArrayList<ResultDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultDTO resultDTO = null;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("select * from result_master where userid = '"
							+ userid + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultDTO = new ResultDTO();
				resultDTO.setQuiz_id(rs.getString("quiz_id"));
				resultDTO.setScore(rs.getInt("result"));
				resultDTO.setUserid(rs.getString("userid"));
				pstmt1 = con
						.prepareStatement("select quiz_name from quiz_master where quiz_id = '"
								+ resultDTO.getQuiz_id() + "'");
				rs1 = pstmt1.executeQuery();
				rs1.next();
				resultDTO.setQuiz_name(rs1.getString("quiz_name"));
				resultList.add(resultDTO);
			}
		} finally {
			if (rs1 != null) {
				rs1.close();
			}
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return resultList;
	}

	public static boolean deleteQuiz(String quiz_id)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int recordCount1 = 0;
		int recordCount2 = 0;
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt1 = con
					.prepareStatement("delete from quiz_master where quiz_id = '"
							+ quiz_id + "'");
			recordCount1 = pstmt1.executeUpdate();

			pstmt2 = con
					.prepareStatement("delete from question_master where quiz_id = '"
							+ quiz_id + "'");
			recordCount2 = pstmt2.executeUpdate();

			if (recordCount1 > 0 || recordCount2 > 0) {
				result = true;
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (pstmt2 != null) {
				pstmt2.close();
			}
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static boolean deleteQuiz(String quiz_id, String userid)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		int recordCount1 = 0;
		int recordCount2 = 0;
		int recordCount3 = 0;
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt1 = con
					.prepareStatement("delete from quiz_master where quiz_id = '"
							+ quiz_id + "'");
			recordCount1 = pstmt1.executeUpdate();

			pstmt2 = con
					.prepareStatement("delete from question_master where quiz_id = '"
							+ quiz_id + "'");
			recordCount2 = pstmt2.executeUpdate();
			pstmt3 = con
					.prepareStatement("delete from faculty_quiz where userid = '"
							+ userid + "'");
			recordCount3 = pstmt3.executeUpdate();
			if (recordCount1 > 0 || recordCount2 > 0 || recordCount3 > 0) {
				result = true;
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (pstmt3 != null) {
				pstmt3.close();
			}
			if (pstmt2 != null) {
				pstmt2.close();
			}
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static QuizMasterDTO createquiz(String quiz_name)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		QuizMasterDTO quizMasterDTO = new QuizMasterDTO();
		int maxQuizId = 0;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select quiz_id from quiz_master");
			while (rs.next()) {
				maxQuizId = Integer.parseInt(rs.getString("quiz_id"));
			}
			maxQuizId++;
			quizMasterDTO.setQuiz_name(quiz_name);
			quizMasterDTO.setQuiz_id(Integer.toString(maxQuizId));
			pstmt = con
					.prepareStatement("insert into quiz_master(quiz_id,quiz_name) values(?,?)");
			pstmt.setString(1, quizMasterDTO.getQuiz_id());
			pstmt.setString(2, quizMasterDTO.getQuiz_name());
			pstmt.executeUpdate();
		} finally {
			// Step -5 Close the resources
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return quizMasterDTO;
	}

	public static void facultyQuiz(String userid, String quiz_id,
			String quiz_name) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			pstmt = con
					.prepareStatement("insert into faculty_quiz(userid,quiz_id,quiz_name) values(?,?,?)");
			pstmt.setString(1, userid);
			pstmt.setString(2, quiz_id);
			pstmt.setString(3, quiz_name);
			pstmt.executeUpdate();
		} finally {
			// Step -5 Close the resources
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public static boolean insertQuestion(QuestionDTO questionDTO)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxQuestionId = 0;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select question_id from question_master where quiz_id = '"
							+ questionDTO.getQuiz_id() + "'");
			while (rs.next()) {
				System.out.println(rs.getString("question_id"));
				maxQuestionId = Integer.parseInt(rs.getString("question_id"));
			}
			maxQuestionId++;
			questionDTO.setQuestion_id(Integer.toString(maxQuestionId));
			pstmt = con
					.prepareStatement("insert into question_master(quiz_id,question_id,question,option1,option2,option3,option4,answer) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, questionDTO.getQuiz_id());
			pstmt.setString(2, questionDTO.getQuestion_id());
			pstmt.setString(3, questionDTO.getQuestion());
			pstmt.setString(4, questionDTO.getOption1());
			pstmt.setString(5, questionDTO.getOption2());
			pstmt.setString(6, questionDTO.getOption3());
			pstmt.setString(7, questionDTO.getOption4());
			pstmt.setString(8, questionDTO.getAnswer());
			int recordInsert = 0;
			recordInsert = pstmt.executeUpdate();
			if (recordInsert > 0) {
				result = true;
			}
		} finally {
			// Step -5 Close the resources
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	public static boolean deleteQuestion(QuestionDTO questionDTO)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		int recordCount1 = 0;
		boolean result = false;
		try {
			con = getConnection();
			pstmt1 = con
					.prepareStatement("delete from question_master where quiz_id = '"
							+ questionDTO.getQuiz_id()
							+ "' and question  = '"
							+ questionDTO.getQuestion() + "'");
			recordCount1 = pstmt1.executeUpdate();
			if (recordCount1 > 0) {
				result = true;
			}
		} finally {
			if (pstmt1 != null) {
				pstmt1.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;
	}
}
