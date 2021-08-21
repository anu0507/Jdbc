package com.jdbc.entity;

public class StudentEntity {
	private int StudentId;
	private String StudentName;
	private int StudentPhone;
	private String StudentEmail;
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		this.StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		this.StudentName = studentName;
	}
	public int getStudentPhone() {
		return StudentPhone;
	}
	public void setStudentPhone(int studentPhone) {
		StudentPhone = studentPhone;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.StudentEmail = studentEmail;
	}
	

}
