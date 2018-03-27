package com.student.Service;

import java.util.List;

import com.common.ContextHolder;
import com.common.IChooseDataSource;
import com.student.Student;

public interface IStudentservice {
	
	@IChooseDataSource(value = ContextHolder.postgres_db)
	int add(Student student);

	List<Student> getList();
}
