package com.exam.dto;

public class QueryDto {
	private String name;
	private String email;
	private String phone;
	private String query;

	@Override
	public String toString() {
		return "QueryDto [name=" + name + ", email=" + email + ", phone="
				+ phone + ", query=" + query + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
