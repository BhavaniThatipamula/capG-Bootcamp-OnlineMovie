package com.cg.sprint.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AdminException 
{
	@ExceptionHandler(value={AdminAccountNotFoundException.class })
	public ResponseEntity<Object> exception(AdminAccountNotFoundException exception)
	{
	      return new ResponseEntity<>("Admin account not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value={IdNotFoundException.class })
	public ResponseEntity<Object> exception(IdNotFoundException exception)
	{
	      return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
	}
	
}