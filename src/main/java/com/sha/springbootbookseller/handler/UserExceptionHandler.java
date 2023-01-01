package com.sha.springbootbookseller.handler;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleInvalidArgument(ConstraintViolationException exception)
	{
		Map<String, String> errorMap=new HashMap<>();
		exception.getConstraintViolations().forEach(error -> {
			errorMap.put(error.getPropertyPath().toString(), error.getMessage());
		});
		return errorMap;
		
	}

}
