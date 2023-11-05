package com.Patient_details.excptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> IllegalArgumentException(IllegalArgumentException ex) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), LocalDate.now());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MyException.class)
	public ResponseEntity<?> myExceptionHandler (MyException ex) {

		ErrorDetails error = new ErrorDetails(ex.getMessage(), LocalDate.now());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
