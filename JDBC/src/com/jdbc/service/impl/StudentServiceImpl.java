package com.jdbc.service.impl;

import java.util.List;
import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.impl.StudentDAOImpl;
import com.jdbc.entity.StudentEntity;
import com.jdbc.mapper.StudentMapper;
import com.jdbc.mapper.StudentMapperImpl;
import com.jdbc.model.Student;
import com.jdbc.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getAllStudent() {
		StudentDAO dao = new StudentDAOImpl();
		List<StudentEntity> list = dao.findAll();

		System.out.println(list + "  anu");

		StudentMapper mapper = new StudentMapperImpl();
		return mapper.mapToStudent(list);

	}

	@Override
	public Student getOneStudent(int StudentId) {
		return null;
	}

	@Override
	public String updateStudent(Student stu) {
		return null;
	}

	@Override
	public String deleteStudent(int StudentId) {
		return null;
	}

}
