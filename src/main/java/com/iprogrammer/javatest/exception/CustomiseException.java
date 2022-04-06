package com.iprogrammer.javatest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomiseException {

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<String> globalHandler(Exception exception, WebRequest request){
		String error = exception.getLocalizedMessage();
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = DataNotFoundException.class)
	public final ResponseEntity<String> dataNotfoundHandler(Exception exception, WebRequest request){
		String error = exception.getLocalizedMessage();
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
