package com.canteen.jdbc;

public class Test {
	public static void main(String[] args) {
		try {
			// Date date = new Date();
			CloseCanteen mysqlToXls = new CloseCanteen("canteen_managment",
					"root", "");
			mysqlToXls.generateXls("current_order", "adi.xls");
			System.out.println();
			mysqlToXls.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
