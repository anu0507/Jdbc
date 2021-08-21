package com.jdbc.dao.impl;

import java.beans.Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.StudentDAO;
import com.jdbc.entity.StudentEntity;
import com.jdbc.util.JdbcUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public List<StudentEntity> findAll() {
		List<StudentEntity> list = null;
		Connection con = JdbcUtil.getConnection();
		String sql = "select* from Student";
		java.sql.Statement st = null;
		try {
			st = con.createStatement();

			ResultSet executeQuery = st.executeQuery(sql);
			list = new ArrayList<>();

			while (executeQuery != null && executeQuery.next()) {
				System.out.println(executeQuery + "Anu");

				int sid = executeQuery.getInt(1);
				String stuName = executeQuery.getString(2);
				int phone = executeQuery.getInt(3);
				String email = executeQuery.getString(4);

				StudentEntity entity = new StudentEntity();
				entity.setStudentId(sid);
				entity.setStudentName(stuName);
				entity.setStudentPhone(phone);
				entity.setStudentEmail(email);
				list.add(entity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			JdbcUtil.closeResource(con, st);
		}*/
		return list;
	}

	@Override
	public StudentEntity findOneStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int  updateStudent(int StudentId) {
		List<StudentEntity> list = null;

		Connection con = JdbcUtil.getConnection();
		String url = " jdbc:mysql://localhost:3306/testdb";
		String sql = "update student set stu_name = 'anu' where stu_id = 102";
		java.sql.Statement st = null;

		try {
			st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			list = new ArrayList<>();
			while (preparedStatement != null && ((ResultSet) preparedStatement).next()) {
				System.out.println(preparedStatement + "update successful");
				int sid = executeUpdate().getInt(1);
				int stu_phone = executeUpdate().getInt(3);
				StudentEntity studentEntity = new StudentEntity();
				studentEntity.setStudentId(sid);
				studentEntity.setStudentPhone(stu_phone);
				list.add(studentEntity);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}/* finally {

			JdbcUtil.closeResource(con, st);

		}*/ //return null;
		return StudentId;
		

	}

	private ResultSet executeUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteStudent(int StudentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
/*
 * Steps to Write JDBC Program Step 1: Load the Driver class.
 * class.forNAME("Driver Name") Step 2: Establish the Connection between the
 * JDBC program and Database. Step 3: Prepare the SQL statement. Step 4: Create
 * the JDBC statement. Step 5: Submit the SQL statement to Database using JDBC
 * statement. Step 6: Process the result. Step 7: Close all the resources.
 */
