package com.cg.sprint.exceptions;

@SuppressWarnings("serial")
public class AdminAccountNotFoundException extends RuntimeException
{
	public AdminAccountNotFoundException()
	{
		super();
	}

	public AdminAccountNotFoundException(String message) 
	{
		super(message);
	}
}
