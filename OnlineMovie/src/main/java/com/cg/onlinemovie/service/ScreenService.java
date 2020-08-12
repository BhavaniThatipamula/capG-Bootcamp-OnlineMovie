package com.cg.onlinemovie.service;

import java.util.List;

import com.cg.onlinemovie.entity.Screen;

import com.cg.onlinemovie.exception.OnlineMovieException;

public interface ScreenService {
	
	
	public Screen addScreen(int theatreId, Screen screen)throws OnlineMovieException;
	
	public Screen deleteScreen(int screenId)throws OnlineMovieException;
	
	public List<Screen>getAllScreens(int theatreId)throws OnlineMovieException;
	
	public Screen updateScreen(int theatreId, int screenId , Screen screen)throws OnlineMovieException;
	
	public Screen getScreen(int screenId) throws OnlineMovieException;
	
	public List<Screen> showAllScreens();
	
	

}
