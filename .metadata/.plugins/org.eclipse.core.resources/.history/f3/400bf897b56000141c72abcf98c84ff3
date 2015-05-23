package com.canteen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.canteen.dto.FeedbackDTO;
import com.canteen.dto.ItemDTO;
import com.canteen.dto.OrderDTO;
import com.canteen.dto.ReportDTO;
import com.canteen.dto.UserDTO;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * 
 * @author aditya
 *
 */
public class JDBC {
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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

	public static List<FeedbackDTO> getFeedback()
			throws ClassNotFoundException, SQLException {
		List<FeedbackDTO> feedback = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FeedbackDTO feedbackDTO;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from feedback");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedbackDTO = new FeedbackDTO();
				feedbackDTO.setText(rs.getString("message"));
				feedbackDTO.setCategory(rs.getString("category"));
				feedbackDTO.setId(rs.getInt("report_id"));
				feedbackDTO.setName(rs.getString("name"));
				feedback.add(feedbackDTO);
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

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean deleteFeedbacks(String[] ids)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int recordCount = 0;
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			for (String id : ids) {
				pstmt = con
						.prepareStatement("delete from feedback where report_id = '"
								+ id + "'");
				recordCount = pstmt.executeUpdate();
			}
			if (recordCount > 0) {
				result = true;
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * @param userDTO
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws MySQLIntegrityConstraintViolationException
	 */
	public static boolean addNewUser(UserDTO userDTO) throws SQLException,
			ClassNotFoundException, MySQLIntegrityConstraintViolationException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("insert into user_table values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, userDTO.getAccount_number());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setString(3, userDTO.getName());
			pstmt.setString(4, userDTO.getEmail());
			pstmt.setString(5, userDTO.getPhoneno());
			pstmt.setString(6, userDTO.getRollno());
			pstmt.setDouble(7, userDTO.getBalance());
			pstmt.setString(8, userDTO.getLast_recharge());
			pstmt.setInt(9, 0);
			System.out.println(pstmt.toString());
			rs = pstmt.executeUpdate();
			System.out.println(rs);
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

	/**
	 * 
	 * @param account_number
	 * @param amount
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("resource")
	public static boolean recharge(String account_number, double amount)
			throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		double balance = 0;
		int rs;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("select balance from user_table where account_number = '"
							+ account_number + "'");
			resultSet = pstmt.executeQuery();
			while (resultSet.next())
				balance = resultSet.getDouble("balance");
			System.out.println(balance);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = sdf.format(date);
			System.out.println(currentDate);
			pstmt = con.prepareStatement("update user_table set balance = '"
					+ (balance + amount) + "' where account_number = '"
					+ account_number + "'");
			rs = pstmt.executeUpdate();
			pstmt = con
					.prepareStatement("update user_table set last_recharge = '"
							+ currentDate + "' where account_number = '"
							+ account_number + "'");
			rs = rs + pstmt.executeUpdate();
			if (rs > 1) {
				result = true;
			} else {
				con.rollback();
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<OrderDTO> getAllOrders() throws ClassNotFoundException,
			SQLException {
		List<OrderDTO> orders = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderDTO orderDTO;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from current_order");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderDTO = new OrderDTO();
				orderDTO.setId(rs.getInt("id"));
				orderDTO.setAmount(rs.getInt("amount"));
				orderDTO.setItems(rs.getString("items"));
				orderDTO.setName(rs.getString("name"));
				orderDTO.setToken(rs.getInt("token"));
				orderDTO.setTime(rs.getString("time"));
				orders.add(orderDTO);
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
		return orders;
	}

	/**
	 * 
	 * @param ids
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean deleteOrders(String[] ids)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int recordCount = 0;
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			for (String id : ids) {
				pstmt = con
						.prepareStatement("delete from current_order where token = '"
								+ id + "'");
				recordCount = pstmt.executeUpdate();
			}
			if (recordCount > 0) {
				result = true;
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	public static List<ItemDTO> getAllItems() throws ClassNotFoundException,
			SQLException {
		List<ItemDTO> items = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDTO itemDTO;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from canteen_menu");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				itemDTO = new ItemDTO();
				itemDTO.setId(rs.getInt("id"));
				itemDTO.setName(rs.getString("name"));
				itemDTO.setPrice(rs.getString("price"));
				itemDTO.setisAvailable(rs.getBoolean("isAvailable"));
				items.add(itemDTO);
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
		return items;
	}

	public static ItemDTO getItemDetail(int id) throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDTO itemDTO;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("select * from canteen_menu where id= '"
							+ id + "'");
			rs = pstmt.executeQuery();
			rs.next();
			itemDTO = new ItemDTO();
			itemDTO.setId(rs.getInt("id"));
			itemDTO.setName(rs.getString("name"));
			itemDTO.setPrice(rs.getString("price"));
			itemDTO.setisAvailable(rs.getBoolean("isAvailable"));

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

	public static boolean updateItem(ItemDTO itemDTO)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int r = 0;
		boolean result = false;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("update canteen_menu set name=?,price=? where id='"
							+ itemDTO.getId() + "' ");
			pstmt.setString(1, itemDTO.getName());
			pstmt.setString(2, itemDTO.getPrice());
			r = pstmt.executeUpdate();
			if(r>0)
				result = true;
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

	public static boolean addNewItem(String name, String amount)
			throws SQLException, ClassNotFoundException,
			MySQLIntegrityConstraintViolationException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			con = getConnection();
			pstmt = con
					.prepareStatement("insert into canteen_menu(name,price,isAvailable) values(?,?,?);");

			pstmt.setString(1, name.trim());
			pstmt.setString(2, amount.trim());
			pstmt.setInt(3, 0);
			System.out.println(pstmt.toString());
			rs = pstmt.executeUpdate();
			System.out.println(rs);
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

	public static boolean deleteItems(String[] ids)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int recordCount = 0;
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			for (String id : ids) {
				pstmt = con
						.prepareStatement("delete from canteen_menu where id = '"
								+ id + "'");
				recordCount = pstmt.executeUpdate();
			}
			if (recordCount > 0) {
				result = true;
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	public static List<UserDTO> getAllUsers() throws ClassNotFoundException,
			SQLException {
		List<UserDTO> users = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO userDTO;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from user_table");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userDTO = new UserDTO();
				userDTO.setAccount_number(rs.getString("account_number"));
				userDTO.setBalance(rs.getDouble("balance"));
				userDTO.setName(rs.getString("name"));
				users.add(userDTO);
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
		return users;
	}

	public static boolean deleteCustomers(String[] ids)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int recordCount = 0;
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			for (String id : ids) {
				pstmt = con
						.prepareStatement("delete from user_table where account_number = '"
								+ id + "'");
				recordCount = pstmt.executeUpdate();
			}
			if (recordCount > 0) {
				result = true;
				con.commit();
			} else {
				con.rollback();
			}
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	public static boolean updateAvailableItems(String[] ids)
			throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			con = getConnection();
			if (ids == null) {
				pstmt = con
						.prepareStatement("update canteen_menu set isAvailable = '0'");
				rs = pstmt.executeUpdate();

				if (rs > 0) {
					result = true;
				} else {
					con.rollback();
				}
			} else {
				pstmt = con
						.prepareStatement("update canteen_menu set isAvailable = '0'");
				rs = pstmt.executeUpdate();
				pstmt.close();
				for (String id : ids) {
					pstmt = con
							.prepareStatement("update canteen_menu set isAvailable = '1' where id = '"
									+ id + "'");
					rs = pstmt.executeUpdate();
				}
				if (rs > 0) {
					result = true;
				} else {
					con.rollback();
				}
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

	public static ArrayList<ReportDTO> getReport(Date date) throws ClassNotFoundException, SQLException {
		ArrayList<ReportDTO> reports = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String d1 = ""+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		String d2 = ""+cal2.get(Calendar.YEAR)+"-"+/*cal2.get(Calendar.MONTH)*/10+"-"+cal2.get(Calendar.DAY_OF_MONTH);
		System.out.println(d1);
		System.out.println(d2);
		
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from current_order where time > '"+d1+"' and time < '"+d2+"' ;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReportDTO report = new ReportDTO();
				report.setAmount(rs.getDouble("amount"));
				report.setCustomer(rs.getString("name"));
				report.setDate(rs.getDate("time"));
				report.setItem(rs.getString("items"));
				reports.add(report);
			}
			System.out.println(reports.toString());
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
		return reports;
	}
}
