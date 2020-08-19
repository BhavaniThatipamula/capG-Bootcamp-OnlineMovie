package com.cg.sprint.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class UserException  {
	@ExceptionHandler(value={UserAccountNotFoundException.class })
	public ResponseEntity<Object> exception(UserAccountNotFoundException exception)
	{
	      return new ResponseEntity<>("User account not found", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value={InvalidBookingDetailsException.class })
	public ResponseEntity<Object> exception(InvalidBookingDetailsException exception) 
	{
	      return new ResponseEntity<>("invalid booking details", HttpStatus.NOT_FOUND);
    }
	//user	
}