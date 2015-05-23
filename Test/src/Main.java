import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {

	private Connection connection = null;

	public Main(String database, String user, String password)
			throws ClassNotFoundException, SQLException {

		// Create MySQL database connection
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3309/" + database;
		connection = DriverManager.getConnection(url, user, password);
	}

	public void generateXls(String tablename, String filename)
			throws SQLException, FileNotFoundException, IOException {

		// Create new Excel workbook and sheet
		HSSFWorkbook xlsWorkbook = new HSSFWorkbook();
		HSSFSheet xlsSheet = xlsWorkbook.createSheet();
		short rowIndex = 0;

		// Execute SQL query
		PreparedStatement stmt = connection.prepareStatement("select * from "
				+ tablename);
		ResultSet rs = stmt.executeQuery();

		// Get the list of column names and store them as the first
		// row of the spreadsheet.
		ResultSetMetaData colInfo = rs.getMetaData();
		List<String> colNames = new ArrayList<String>();
		HSSFRow titleRow = xlsSheet.createRow(rowIndex++);

		for (int i = 1; i <= colInfo.getColumnCount(); i++) {
			colNames.add(colInfo.getColumnName(i));
			titleRow.createCell((short) (i - 1)).setCellValue(
					new HSSFRichTextString(colInfo.getColumnName(i)));
			xlsSheet.setColumnWidth((short) (i - 1), (short) 4000);
		}

		// Save all the data from the database table rows
		while (rs.next()) {
			HSSFRow dataRow = xlsSheet.createRow(rowIndex++);
			short colIndex = 0;
			for (String colName : colNames) {
				dataRow.createCell(colIndex++).setCellValue(
						new HSSFRichTextString(rs.getString(colName)));
			}
		}

		// Write to disk
		xlsWorkbook.write(new FileOutputStream(filename));
	}

	// Close database connection
	public void close() throws SQLException {
		connection.close();
	}

	public static void main(String[] args) {
		try {
			// Date date = new Date();
			Main mysqlToXls = new Main("canteen_managment", "root", "");
			mysqlToXls.generateXls("current_order", "adi123.xls");
			System.out.println();
			mysqlToXls.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}