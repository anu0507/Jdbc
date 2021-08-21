package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1UTIL {
	static Connection con=null;
	static {
		try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","@nudubey");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
static  {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
public static Connection getConnection() throws SQLException {
//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","@nudubey");
    return con;
}
public static void closeResource(Connection con,Statement st) {
	try {
		if(con!=null) {
			con.close();
		}
		if(st!=null) {
			st.close();
		}
	}
	catch(SQLException e) {
		
	}
}
}
