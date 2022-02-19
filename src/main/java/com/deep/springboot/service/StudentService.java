package com.deep.springboot.service;

import java.util.List;

import com.deep.springboot.model.Student;

public interface StudentService {

	public Student save(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(long id);
	
	public Student update(long id,Student student);
	
	public void delete(long id);





}
