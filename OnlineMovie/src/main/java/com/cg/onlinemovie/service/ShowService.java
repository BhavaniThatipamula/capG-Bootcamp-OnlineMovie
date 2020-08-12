package com.cg.onlinemovie.service;

import java.util.List;

import com.cg.onlinemovie.entity.Show;
import com.cg.onlinemovie.exception.OnlineMovieException;

public interface ShowService {

	/****************************************************************************************************************************
	 * @author            BhavaniThatipamula
	 * Description        It is a service interface which is implemented by the class having business logic for add,delete           
	 *                    functionalities of show the reference of this interface is to be given to whichever class wanted to use these 
	 *                    functionalities.
	 * Version            1.0 
	 * Created Date       12-AUG-2020
	 *****************************************************************************************************************************/
	public Show addShow(int movieId, Show show)throws OnlineMovieException;
	
	public Show deleteShow(int movieId, int showId)throws OnlineMovieException;
	
	public List<Show> getAllShows(int movieId)throws OnlineMovieException;
	
	public List<Show> showAllShows();
	
	public Show getShow(int showId)throws OnlineMovieException;
	

}
