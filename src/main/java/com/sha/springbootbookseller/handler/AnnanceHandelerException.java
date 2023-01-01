package com.sha.springbootbookseller.handler;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sha.springbootbookseller.exceptions.AnnanceNotFoundException;

@RestControllerAdvice
public class AnnanceHandelerException {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AnnanceNotFoundException.class)
	public Map<String, String> handleAnnanceNotFoundException(AnnanceNotFoundException ex){
		Map<String, String> map=new HashMap<>();
		map.put("errorMessage", ex.getMessage());
		return map;
	}

}
