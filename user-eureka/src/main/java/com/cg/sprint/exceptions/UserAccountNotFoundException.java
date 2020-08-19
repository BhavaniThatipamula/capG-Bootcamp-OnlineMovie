package com.cg.sprint.exceptions;

@SuppressWarnings("serial")
public class UserAccountNotFoundException extends RuntimeException
{
	public UserAccountNotFoundException()
	{
		super();
	}

	public UserAccountNotFoundException(String message) 
	{
		super(message);
	}
	//user
}
