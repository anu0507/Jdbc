package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Cilent {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
	  
	try {
		Class.forName("com.mysql.jdbc.Driver");
		final String url = "jdbc:mysql://localhost:3306/testdb";
		con = DriverManager.getConnection(url, "root", "@nudubey");
		// String sql = "insert into student values(101,'Anu',234858,'anu@gmail.com')";
		String sql = "delete from student where stu_id = 102";
		st = con.createStatement();
		int i = st.executeUpdate(sql);
		if (i == 1) {
			System.out.println("record deleted");
		} else {
			System.out.println("record not deleted");
		}

	} catch (ClassNotFoundException | SQLException e) {

	} finally {
		try {
			if (con != null) {
				con.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {

		}
	}
	}

}
