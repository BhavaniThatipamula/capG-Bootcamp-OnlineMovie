package com.cg.onlinemovie.service;

import java.util.List;

import com.cg.onlinemovie.entity.Show;
import com.cg.onlinemovie.exception.OnlineMovieException;

public interface ShowService {

	
	public Show addShow(int movieId, Show show)throws OnlineMovieException;
	
	public Show deleteShow(int movieId, int showId)throws OnlineMovieException;
	
	public List<Show> getAllShows(int movieId)throws OnlineMovieException;
	
	public List<Show> showAllShows();
	
	public Show getShow(int showId)throws OnlineMovieException;
	

}
