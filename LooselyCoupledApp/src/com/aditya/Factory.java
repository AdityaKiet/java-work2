package com.aditya;

import java.util.ResourceBundle;

public class Factory {
	private Factory() {

	}

	public static X getObject() {
		ResourceBundle rb = ResourceBundle.getBundle("object");
		String className = rb.getString("classname");
		X obj = null;
		try {
			obj = (X)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return new C();
		//return new B();
		return obj;
	}
}
