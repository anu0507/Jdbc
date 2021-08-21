package com.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientTwo {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;

		try {
			 con = JdbcUtil.getConnection();

			String sql = "select * from student";
		st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				do {
					System.out.println(
							rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				} while (rs.next());

			}
		} catch (SQLException e) {

		} 
			/* finally { JdbcUtil.closeResource(con, st); }*/
			 
	}

}
