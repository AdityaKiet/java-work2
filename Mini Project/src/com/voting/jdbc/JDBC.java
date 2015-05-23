package com.voting.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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
			// Step -3 Query
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

}
