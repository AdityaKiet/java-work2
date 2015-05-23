package com.aditya;

public class CallB {
	public static void main(String[] args) {
		//X b = new B();
		X b = Factory.getObject();
		// B b = new B();
		b.show();
		// b.display();
	}
}
