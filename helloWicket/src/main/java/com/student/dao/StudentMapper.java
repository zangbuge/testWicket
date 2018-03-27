package com.student.dao;

import java.util.List;

import com.student.Student;

public interface StudentMapper {
	
	int add(Student student);
	
	List<Student> getList();
}
