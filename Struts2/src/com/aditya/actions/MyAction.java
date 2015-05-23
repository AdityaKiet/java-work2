package com.aditya.actions;

import com.opensymphony.xwork2.Action;

public class MyAction implements Action {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() {
		this.setMessage("Hello Client");
		return "success";
	}
}
