package com.cg.onlinemovie.service;

import java.util.List;

import com.cg.onlinemovie.entity.Screen;

import com.cg.onlinemovie.exception.OnlineMovieException;

public interface ScreenService {
	
/****************************************************************************************************************************
 * @author            BhavaniThatipamula
 * Description        It is a service interface which is implemented by the class having business logic for add,delete,update          
 *                    functionalities of screen the reference of this interface is to be given to whichever class wanted to use 
 *                    these functionalities.
 * Version            1.0 
 * Created Date       12-AUG-2020
 *****************************************************************************************************************************/
	public Screen addScreen(int theatreId, Screen screen)throws OnlineMovieException;
	
	public Screen deleteScreen(int screenId)throws OnlineMovieException;
	
	public List<Screen>getAllScreens(int theatreId)throws OnlineMovieException;
	
	public Screen updateScreen(int theatreId, int screenId , Screen screen)throws OnlineMovieException;
	
	public Screen getScreen(int screenId) throws OnlineMovieException;
	
	public List<Screen> showAllScreens();
	
	

}
