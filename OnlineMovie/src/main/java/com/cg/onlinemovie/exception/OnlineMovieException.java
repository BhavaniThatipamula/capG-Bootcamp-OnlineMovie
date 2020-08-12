package com.cg.onlinemovie.exception;

public class OnlineMovieException extends Exception{

	/*************************************************************************************************************************
	 *          @author          BhavaniThatipamula
	 *          Description      It is an exception class which creates a user defined exception which is to be called whenever,
	 *          				 the user search for the screen or show Id if it not found in data abse
	 *         Version           1.0
	 *         Created Date      12=AUG-2020
	 *************************************************************************************************************************/
	public OnlineMovieException(String message)
	{
		super(message);
	}
	public OnlineMovieException()
	{
		super();
	}

}
