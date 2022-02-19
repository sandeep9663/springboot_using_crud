package com.deep.springboot.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.deep.springboot.model.Student;
@Repository
public interface StudentRepository extends JpaRepositoryImplementation<Student,Long> {

	



	



}
