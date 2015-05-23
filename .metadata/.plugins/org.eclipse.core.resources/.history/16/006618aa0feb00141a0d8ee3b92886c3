package com.ws.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ws.dto.AdminDTO;
import com.ws.dto.RequestDTO;
import com.ws.dto.UserDTO;
import com.ws.servlets.GetRequests;
import com.ws.servlets.GetUsers;

public class JDBC {

	private JDBC(){

	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException	{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driverName = rb.getString("drivername");
		Class.forName(driverName);
		String url = rb.getString("dburl");
		String userid = rb.getString("userid");
		String password = rb.getString("password");
		Connection con = DriverManager.getConnection(url,userid,password);
		return con;
	}

	public static boolean checkAdminLogin(AdminDTO adminDTO) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConnection();
		ps = con.prepareStatement("select id from admin where admin_id = ? and password = ?");
		ps.setString(1, adminDTO.getAdminId());
		ps.setString(2, adminDTO.getPassword());
		rs = ps.executeQuery();
		if(rs.next()){
			return true;
		}
		else{
			return false;
		}
	}

	private static int countRequest() throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConnection();
		ps = con.prepareStatement("select count(*) as count from request;");
		rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("count");
		}
		else{
			return 0;
		}
	}

	public static List<RequestDTO> getRequests(String search, int startRow, int noOfRecords, int echo) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int recordsNo = 0;
		ResultSet rs = null;
		con = getConnection();
		List<RequestDTO> requestList = new ArrayList<RequestDTO>();
		RequestDTO request = null;
		recordsNo = countRequest();
		GetRequests.totalRecords = recordsNo;
		StringBuilder sql = new StringBuilder();
		sql = sql.append("select * from request ");
		if(recordsNo > 0){
			sql.append(" where phone_no like '"+search+"%' order by phone_no asc limit ?,?");
			
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, startRow);
			ps.setInt(2, noOfRecords);
		}else{
			ps = con.prepareStatement(sql.toString());
		}
		
		rs = ps.executeQuery();
		while(rs.next()){
			request = new RequestDTO();
			request.setId(rs.getInt("id"));
			request.setImei(rs.getString("imei"));
			request.setLatitude(rs.getString("latitude"));
			request.setLongitude(rs.getString("longitude"));
			request.setMob_no(rs.getString("phone_no"));
			request.setAddress(rs.getString("address"));
			requestList.add(request);
		}
		return requestList;
	}
	
	private static int countUsers() throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConnection();
		ps = con.prepareStatement("select count(*) as count from user_master;");
		rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("count");
		}
		else{
			return 0;
		}
	}

	public static List<UserDTO> getUsers(String search, int startRow, int noOfRecords, int echo) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int recordsNo = 0;
		ResultSet rs = null;
		con = getConnection();
		List<UserDTO> usersList = new ArrayList<UserDTO>();
		UserDTO user = null;
		recordsNo = countUsers();
		GetUsers.totalRecords = recordsNo;
		StringBuilder sql = new StringBuilder();
		sql = sql.append("select * from user_master ");
		if(recordsNo > 0){
			sql.append(" where name like '"+search+"%' order by name asc limit ?,?");
			
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, startRow);
			ps.setInt(2, noOfRecords);
		}else{
			ps = con.prepareStatement(sql.toString());
		}
		
		rs = ps.executeQuery();
		while(rs.next()){
			user = new UserDTO();
			user.setName(rs.getString("name"));
			user.setImei(rs.getString("imei"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setMobNo(rs.getString("contact_number"));
			user.setParentMobNo(rs.getString("parent_contact_number"));
			user.setPostalCode(rs.getString("postal_code"));
			user.setVoterId(rs.getString("voter_id"));
			usersList.add(user);
		}
		return usersList;
	}

	public static boolean deleteRequest(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		con = getConnection();
		ps = con.prepareStatement("DELETE FROM request WHERE id = ?;");
		ps.setInt(1, id);
		rs = ps.executeUpdate();
		if(rs > 0){
			return true;
		}
		else{
			return false;
		}
	}
}
