
package com.cg.sprint.exceptions;

@SuppressWarnings("serial")
public class InvalidBookingDetailsException extends RuntimeException
{
	public InvalidBookingDetailsException()
	{
		super();
	}

	public InvalidBookingDetailsException(String message) 
	{
		super(message);
	}
	//user
}