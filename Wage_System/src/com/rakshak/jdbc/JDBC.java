package com.rakshak.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rakshak.dto.LabourDTO;

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

	public static List<LabourDTO> getLabours(String avail_start_date, String avail_end_date) throws ClassNotFoundException, SQLException {
		List<LabourDTO> labours = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LabourDTO labourDTO;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select labour_master.*,labour_skills.skills from `labour_master` left join `labour_skills` on labour_master.id = labour_skills.id where available_start_date <= '" + avail_start_date + "' and available_end_date >= '" + avail_end_date + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				labourDTO = null;
				labourDTO = new LabourDTO();
				labourDTO.setArea(rs.getString("area"));
				labourDTO.setId(rs.getInt("id"));
				labourDTO.setName(rs.getString("name"));
				labourDTO.setNumber(rs.getString("phone_no"));
				
				if(labours.contains(labourDTO)){
					List<String> skills = new ArrayList<>();
					skills = labours.get(labours.indexOf(labourDTO)).getSkills();
					skills.add(rs.getString("skills"));
					labourDTO.setSkills(skills);
					labours.remove(labourDTO);
					labours.add(labourDTO);
				}else{
					List<String> skills = new ArrayList<>();
					skills.add(rs.getString("skills"));
					labourDTO.setSkills(skills);
					labours.add(labourDTO);
				}
				
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
		return labours;
	}
}
