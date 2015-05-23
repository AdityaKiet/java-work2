package com.canteen.dto;


public class UserDTO {
	private String account_number;
	private String name;
	private String rollno;
	private String password;
	private String email;
	private String phoneno;
	private double balance;
	private String last_recharge;
	private boolean isLogin;

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getLast_recharge() {
		return last_recharge;
	}

	public void setLast_recharge(String last_recharge) {
		this.last_recharge = last_recharge;
	}

	@Override
	public String toString() {
		return "UserDTO [account_number=" + account_number + ", name=" + name
				+ ", rollno=" + rollno + ", password=" + password + ", email="
				+ email + ", phoneno=" + phoneno + ", balance=" + balance
				+ ", last_recharge=" + last_recharge + ", isLogin=" + isLogin
				+ "]";
	}

}
