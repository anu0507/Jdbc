package com.jdbc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtil {

	public static Connection getConnection() {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		Connection con = null;

		try {

			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName(rb.getString(JdbcConstant.Driver));

			final String url = "jdbc:mysql://localhost:3306/testdb";
			con = DriverManager.getConnection(rb.getString(JdbcConstant.URL), rb.getString(JdbcConstant.USERNAME),
					rb.getString(JdbcConstant.PASSWORD));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * public static void closeResource(Connection con, Statement st) { try { if
	 * (con != null) { con.close(); } if (st != null) { st.close(); } } catch
	 * (SQLException e) {
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) { Connection con = null; Statement st
	 * = null; try { // Step 1:Load the Driver class.
	 * Class.forName("com.mysql.jdbc.Driver"); // Step 2: Establish the connection.
	 * final String url = "jdbc:mysql://localhost:3306/testdb"; con =
	 * DriverManager.getConnection(url, "root", "@nudubey"); // Step 3: Prepare the
	 * SQL statement. String sql =
	 * "insert into student values(101,'Anu',234858,'anu@gmail.com')"; // Step 4:
	 * Create JDBC statement. st = con.createStatement(); // Step 5: Submit the SQL
	 * statement to Database using JDBC statement. int x = st.executeUpdate(sql); //
	 * Step 6: Process the result. if (x == 1) {
	 * System.out.println("Record Inserted"); } else {
	 * System.out.println("Record Not Inserted"); } } catch (ClassNotFoundException
	 * | SQLException e) { e.printStackTrace(); } finally { // Step 7: Close all the
	 * resources. try { if (con != null) con.close(); if (st != null) st.close(); }
	 * catch (SQLException e) {
	 * System.out.println("Exception occur while closing the resources"); } }
	 */

}
