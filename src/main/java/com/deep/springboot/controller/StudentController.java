package com.deep.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deep.springboot.exceptionhande.StudentNotFoundException;
import com.deep.springboot.model.Student;
import com.deep.springboot.service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/student")
	public ResponseEntity<Student> save(@RequestBody Student student)
	{
		Student std = studentservice.save(student);
		return new ResponseEntity<Student>(std, HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{
		return studentservice.getAllStudent();
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity studentById(@PathVariable("id") long id) 
	{
	
		Student std = studentservice.getStudentById(id);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	
		
		
		
	}	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") long id,@RequestBody Student studtnt)
	{
		 Student std=studentservice.update(id,studtnt);
		return new ResponseEntity<Student>(std ,HttpStatus.OK);
	}
		
		@DeleteMapping("/student/{id}")
		public ResponseEntity<?> deleteStudentById(@PathVariable("id") long id)
		{
			studentservice.delete(id);
			
			return ResponseEntity.ok().body("Record deleted successfully");
		}
		
		
}



