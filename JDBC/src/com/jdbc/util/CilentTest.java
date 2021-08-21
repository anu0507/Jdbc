package com.jdbc.util;

import java.util.List;
import java.util.Scanner;

public class CilentTest {
	public static void main(String[] args) {
		//Student st=new Student(104,"Anjali","jatav","bhopal");
		JdbcTemplate temp=new JdbcTemplate();
		//Student su = new Student();
	/*	List<Student> students = temp.findByState("Bhopal");
		 students.forEach(System.out::println);*/
		
		//temp.save(st);
		//temp.delete(104);
		//temp.update(101,"anu");
		List<Student> fa = temp.findAll();
		System.out.println(fa);
		/*Student id = temp.findById(102);
		System.out.println(id);*/
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("please enter sid firstName lastName state");
		int sid = sc.nextInt();
		String firstName = sc.next();
		String lastName = sc.next();
		String state = sc.next();
		System.out.println(sid+" "+firstName+" "+lastName+" "+state);
		Student st = new Student(sid,firstName,lastName,state);
		JdbcTemplate temp = new JdbcTemplate();
		temp.save(st);*/
		 
		
		
		
		
		
		
	}

}
