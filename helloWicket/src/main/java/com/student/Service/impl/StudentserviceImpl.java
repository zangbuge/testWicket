package com.student.Service.impl;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Student;
import com.student.Service.IStudentservice;
import com.student.dao.StudentMapper;

@Service("iStudentservice")
public class StudentserviceImpl implements IStudentservice{

	@Autowired
	StudentMapper studentMapper;
	
	
	@Test
	public int add(Student student) {
		// TODO Auto-generated method stub
		student.setName("123");
		student.setSex(new Random().nextInt(100));
		return studentMapper.add(student);
	}
	

	@Test
	public List<Student> getList() {
		// TODO Auto-generated method stub
		return studentMapper.getList();
	}
	
	
	@Test
	public void t(){
		System.out.println(123);
	}

}
