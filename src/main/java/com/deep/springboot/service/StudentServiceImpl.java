package com.deep.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.deep.springboot.dao.StudentRepository;
import com.deep.springboot.exceptionhande.StudentNotFoundException;
import com.deep.springboot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
private StudentRepository studentRepository;
	
	
	@Override
	public Student save(Student student) {
		
		return studentRepository.save(student);	
        
}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
	 Optional<Student> stdData =studentRepository.findById(id);
	 if(stdData.isPresent())
		{
			return stdData.get();			
		}
		else
		{
			throw new StudentNotFoundException("Student not present of id :"+id,HttpStatus.NOT_FOUND);
		}

	}


	public Student update(long id, Student student) {
		
			Student std = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not present of id"+id, HttpStatus.NOT_FOUND));

			std.setName(student.getName());
			std.setAddress(student.getAddress());
			std.setCity(student.getCity());
			studentRepository.save(std);
			return std;
		}

	public void delete(long id) {
		
		studentRepository.deleteById(id);
	}


}