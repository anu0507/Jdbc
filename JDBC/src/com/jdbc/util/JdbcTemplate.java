package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

	private static final String CLOSE_BRACES = ")";
	private static final String OPEN_BRACES = "( ";
	private static final String SINGLE_QUOTE = "'";
	private static final String COMMA = ",";

	public void save(Student stu) {

		// String sql = "insert into student values" +OPEN_BRACES + stu.getSid() + COMMA
		// + SINGLE_QUOTE + stu.getFirstName() + SINGLE_QUOTE + COMMA + SINGLE_QUOTE
		// + stu.getLastName() + SINGLE_QUOTE + COMMA + SINGLE_QUOTE + stu.getState() +
		// SINGLE_QUOTE + CLOSE_BRACES;
		// String sql1=String.format("insert into student values(%d, '%s','%s','%s')",
		// stu.getSid(), stu.getFirstName(), stu.getLastName(),stu.getState());
		// System.out.println(sql1);

		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)")) {
			// st = con.createStatement();

			ps.setInt(1, stu.getSid());
			ps.setString(2, stu.getFirstName());
			ps.setString(3, stu.getLastName());
			ps.setString(4, stu.getState());

			int a = ps.executeUpdate();
			if (a == 1) {
				System.out.println("record inserted");

			} else {
				System.out.println("recored not inserted");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { JdbcUtil.closeResource(con, ps); }
		 */
	}

	public void delete(int sid) {

		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("delete from Student where sid = ?")) {

			ps.setInt(1, sid);
			int y = ps.executeUpdate();
			if (y == 1) {
				System.out.println(" record deleted");
			} else {
				System.out.println("record not deleted");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { JdbcUtil.closeResource(con, ps);
		 * 
		 * }
		 */

	}

	public void update(int stuId, String stuName) {

		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("update Student SET stuName= ?,where stuId = ?")) {

			ps.setString(1, stuName);
			ps.setInt(2, stuId);
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("record updated");
			} else {
				System.out.println("record not updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { JdbcUtil.closeResource(con, ps);
		 * 
		 * }
		 */

	}

	public List<Student> findAll() {

		List<Student> allRecord = new ArrayList();
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from student")) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student std = new Student();
				int sid = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String state = rs.getString(4);
				std.setSid(sid);
				std.setFirstName(firstName);
				std.setLastName(lastName);
				std.setState(state);
				allRecord.add(std);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { JdbcUtil.closeResource(con, ps); }
		 */
		return allRecord;

	}

	public Student findById(int id) {

		Student st = null;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from student where sid= ?")) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				st = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

			} else {
				System.out.println("record not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} /*
			 * finally { JdbcUtil.closeResource(con, ps);
			 * 
			 * }
			 */
		return st;
	}

	public List<Student> findByState(String state) {
		List<Student> stuList = new ArrayList<>();
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from student where state = ?")) {
			ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student();

				int sid = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String state1 = rs.getString(4);
				stu = new Student();
				stu.setSid(sid);
				stu.setFirstName(firstName);
				stu.setLastName(lastName);
				stu.setState(state1);
				stuList.add(stu);

			}

		} catch (SQLException e) {
		}

		return stuList;

	}

}
