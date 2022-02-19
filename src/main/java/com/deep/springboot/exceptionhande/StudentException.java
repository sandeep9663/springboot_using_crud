package com.deep.springboot.exceptionhande;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
public class StudentException extends ResponseEntityExceptionHandler {

		@ExceptionHandler(value=StudentNotFoundException.class)
		public ResponseEntity handleEmployeeAlreadyExistexception(StudentNotFoundException snfe) {
			return new ResponseEntity("Student Not Found in database", HttpStatus.CONFLICT);
		}
}
