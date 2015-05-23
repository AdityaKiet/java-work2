package com.aditya.actions;

public class LoginAction {
	private String userid;
	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String addUser() {
		if (this.userid.equals(this.password)) {
			return "added";
		} else {
			return "not";
		}
	}
}
