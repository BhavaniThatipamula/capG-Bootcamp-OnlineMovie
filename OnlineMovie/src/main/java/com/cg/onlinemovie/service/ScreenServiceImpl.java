package com.cg.onlinemovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinemovie.dao.ScreenDao;
import com.cg.onlinemovie.entity.Screen;
import com.cg.onlinemovie.exception.OnlineMovieException;


@Service
public class ScreenServiceImpl implements ScreenService{
	
	/****************************************************************************************************************************
	 * @author            BhavaniThatipamula
	 * Description        It is a service implementation which is implemented by the class having business logic for add,delete           
	 *                    functionalities of screen service interface
	 * Version            1.0 
	 * Created Date       12-AUG-2020
	 *****************************************************************************************************************************/
	@Autowired
	ScreenDao screenDao;

	/*********************************************************************************************************************************
	 * Method: addScreen
     *Description: To add a screen based on user input of screenId / screenName / No of rows& columns 
	 * @returns  screen - screen is added for particular theatreId.
	 * @throws exception - when theatreID is not present
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
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
	/*********************************************************************************************************************************
	 * Method: deleteScreen
     *Description: To delete a screen based on user input of screenId 
	 * @returns  of type screen - screen is deleted for particular screenId
	 * @throws Exception(OnlineMovieException    - when screenId is not found
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	

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

	/*********************************************************************************************************************************
	 * Method: getAllScreens
     *Description: To get all the screens based on user input of theatreId
	 * @returns screenResponse of type list of screens   -All the screens of user input theatreId
	 * @throws user defined exception                    - when theatreId not found
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/ 

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

	/*********************************************************************************************************************************
	 * Method: updateScreen
     *Description: To update a screen based on user input of theatreId and screenId
	 * @returns screen    - screen is updated for user input screenId and theatreId
	 * @throws user defined exception                    - when screenId not found
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
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
	/*********************************************************************************************************************************
	 * Method: getScreen
     *Description: To get the screen based on screenId
	 * @returns screen                            - All the screens 
                *Created By                       - BhavaniThatipamula
                *Created Date                     - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@Override
	public Screen getScreen(int screenId) throws OnlineMovieException {
		 
		Screen tempScreen=screenDao.findById(screenId).get();
		if(tempScreen==null)
		{
			throw new OnlineMovieException("screen Id not found");
		}
		return tempScreen;
	}
	/*********************************************************************************************************************************
	 * Method: showAllScreens
     *Description: To get all the screens
	 * @returns screenResponse of type list of screens   - All the screens 
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@Override
	public List<Screen> showAllScreens() {
		 
		List<Screen> screenList=screenDao.findAll();
		return screenList;
	}

}
