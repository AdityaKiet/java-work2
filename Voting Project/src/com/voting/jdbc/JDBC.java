package com.voting.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.voting.dto.EmpDTO;

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

	public static boolean checkAdminLogin(String userid, String password)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from adminlogin where id='"
					+ userid + "' and password='" + password + "'");
			if (rs.next()) {
				result = true;
			}
		}

		finally {
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
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from login where id='" + userid
					+ "' and password='" + password + "'");
			if (rs.next()) {
				result = true;
			}
		}

		finally {
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

	public static EmpDTO getItemDetail(String id)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpDTO itemDTO;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from emp_master where id= '"
					+ id + "'");
			rs = pstmt.executeQuery();
			rs.next();
			itemDTO = new EmpDTO();
			itemDTO.setId(rs.getString("id"));
			itemDTO.setName(rs.getString("name"));
			itemDTO.setDesignation(rs.getString("designation"));
			itemDTO.setPhoneno(rs.getString("phoneno"));
			itemDTO.setEmail(rs.getString("email"));
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
		return itemDTO;
	}

	public static List<String> getFeedback() throws ClassNotFoundException,
			SQLException {
		List<String> feedback = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from emp_posts");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedback.add(rs.getString("posts"));
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
		return feedback;
	}

	public static boolean addEmployee(EmpDTO userDTO) throws SQLException,
			ClassNotFoundException, MySQLIntegrityConstraintViolationException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("insert into emp_master values(?,?,?,?,?)");
			pstmt.setString(1, userDTO.getId());
			pstmt.setString(2, userDTO.getName());
			pstmt.setString(3, userDTO.getDesignation());
			pstmt.setString(4, userDTO.getPhoneno());
			pstmt.setString(5, userDTO.getEmail());
			System.out.println(pstmt.toString());
			rs = pstmt.executeUpdate();
			System.out.println(rs);
			pstmt.close();
			pstmt = null;
			pstmt = con.prepareStatement("insert into login values(?,?)");
			pstmt.setString(1, userDTO.getId());
			pstmt.setString(2, "kiet");
			rs = pstmt.executeUpdate();
			if (rs == 1) {
				result = true;
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}

		}
		return result;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		System.out.println(checkAdminLogin("1001", "aditya"));
		checkLogin("1001", "aditya");
	}
}
