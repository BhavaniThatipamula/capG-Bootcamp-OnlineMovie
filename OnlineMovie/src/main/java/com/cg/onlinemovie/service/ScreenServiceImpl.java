package com.cg.onlinemovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinemovie.dao.ScreenDao;
import com.cg.onlinemovie.entity.Screen;
import com.cg.onlinemovie.exception.OnlineMovieException;


@Service
public class ScreenServiceImpl implements ScreenService{
	
	@Autowired
	ScreenDao screenDao;

	@Override
	public Screen addScreen(int theatreId, Screen screen)throws OnlineMovieException {
		
		Screen tempScreen=null;
		List<Screen> listOfScreen = screenDao.existsByTheatreId(theatreId);
		if(listOfScreen!=null)
		{
			tempScreen=screenDao.saveAndFlush(screen);
		}
		else
		{
			
			throw new OnlineMovieException("Theatre Id not present");
		}
		 
		return tempScreen;
	}

	@Override
	public Screen deleteScreen(int screenId) throws OnlineMovieException {
		 Screen screen=null;
		 
		 if(screenDao.existsById(screenId))
		 {
			 screen=screenDao.findById(screenId).get();
			 screenDao.deleteById(screenId);
		 }
		 else
		 {
			 throw new OnlineMovieException("ScreenId not found");
		 }
		return screen;
	}

	 

	@Override
	public List<Screen> getAllScreens(int theatreId) throws OnlineMovieException {
		 
		List<Screen> screenList;
		screenList=screenDao.existsByTheatreId(theatreId);
		if(screenList==null)
		{
			throw new OnlineMovieException("Theatre Id not found");
		}
		else
		{
			return screenList;
		}
 
		
	}

	@Override
	public Screen updateScreen(int theatreId,int screenId, Screen screen) throws OnlineMovieException {
		
		if(screen.getTheatre().getTheatreId()==theatreId)
		{
			   if(screenDao.existsById(screenId))
			    {
				screen=screenDao.saveAndFlush(screen); 
			    }
			    else
			    {
				throw new OnlineMovieException("Screen Id not present");
			    }
		}
		else
		{
			throw new OnlineMovieException("Theatre id not present");
		}
		return screen;
	}

	@Override
	public Screen getScreen(int screenId) throws OnlineMovieException {
		 
		Screen tempScreen=screenDao.findById(screenId).get();
		if(tempScreen==null)
		{
			throw new OnlineMovieException("screen Id not found");
		}
		return tempScreen;
	}

	@Override
	public List<Screen> showAllScreens() {
		 
		List<Screen> screenList=screenDao.findAll();
		return screenList;
	}

}
