package com.cg.onlinemovie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineMovieApplication;
import com.cg.onlinemovie.entity.Screen;
import com.cg.onlinemovie.entity.Theatre;
import com.cg.onlinemovie.exception.OnlineMovieException;
import com.cg.onlinemovie.service.ScreenService;
 
/************************************************************************************************************************************
 *          @author          BhavaniThatipamula
 *          Description      It is a controller class having Request Mapping functions for functionalities of add,delete,update for screen.
 *         Version             1.0
 *         Created Date     12-AUG-2020
 ************************************************************************************************************************************/

@RestController
@CrossOrigin("*")
public class ScreenController {

	@Autowired
	ScreenService screenService;
	
	Logger logger = LoggerFactory.getLogger(OnlineMovieApplication.class);
	String msg;
	
	ResponseEntity screenResponse=null;
	
	/*********************************************************************************************************************************
	 * Method: addScreen
     *Description: To add a screen based on user input of screenId / screenName / No of rows& columns 
	 * @returns screenResponse of type screen - screen is added for particular theatreId.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@PostMapping("screen/theatre/{id}")
	public ResponseEntity<Screen> addScreen(  @RequestBody Screen screen, @PathVariable("id") int theatreId)throws OnlineMovieException
	{ 
		Theatre theatre=new Theatre();
		theatre.setTheatreId(theatreId);
		screen.setTheatre(theatre);
		List<Screen> list=screenService.getAllScreens(theatreId);
		Screen tempScreen=screenService.addScreen(theatreId, screen);
		if(list!=null)
		{
			msg = "adding the screen";
			logger.info(msg);
			screenResponse =new ResponseEntity<Screen>(tempScreen,HttpStatus.OK);
		}
		else
		{
			msg="Not Possible!! TheatreId not exist";
			logger.info(msg);
			screenResponse=new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);
		}
		return screenResponse;
	}
	/*********************************************************************************************************************************
	 * Method: deleteScreen
     *Description: To delete a screen based on user input of screenId 
	 * @returns screenResponse  of type screen - screen is deleted for particular screenId if not shows screen Id not found exception.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@DeleteMapping("screen/{id}")
	public ResponseEntity<Screen> deleteScreen(@PathVariable ("id")int screenId)throws OnlineMovieException
	{  
		Screen temp=screenService.getScreen(screenId);
		
		if(temp!=null)
		{
			msg= "Screen Deleted Successfully";
			logger.info(msg);
			screenService.deleteScreen(screenId);
			screenResponse =new ResponseEntity<Screen>(temp,HttpStatus.OK);
		}
		else
		{
			msg = "Not Possible to delete!! ScreenId not found";
			logger.info(msg);
			screenResponse =new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);
		}
		return screenResponse;
	}
	/*********************************************************************************************************************************
	 * Method: updateScreen
     *Description: To update a screen based on user input of theatreId and screenId
	 * @returns screenResponse of type screen    - screen is updated for user input screenId and theatreId
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@PutMapping("screen/theatre/{id}/screen/{id1}")
	public ResponseEntity<Screen> updateScreen(@PathVariable("id") int theatreId, @PathVariable("id1") int screenId, @RequestBody Screen screen)throws OnlineMovieException
	{ 
		Theatre temptheatre=new Theatre();
		temptheatre.setTheatreId(theatreId);
		screen.setTheatre(temptheatre);
		
		Screen updatedScreen=screenService.updateScreen(theatreId, screenId, screen);
		if(updatedScreen==null)
		{
			msg="Not possible to update";
			logger.info(msg);
			screenResponse =new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);
		}
		else
		{
			msg="Screen Updated";
			logger.info(msg);
			screenResponse =new ResponseEntity<Screen>(updatedScreen,HttpStatus.OK);
		}
		return screenResponse;
	}
	/*********************************************************************************************************************************
	 * Method: getAllScreens
     *Description: To get all the screens based on user input of theatreId
	 * @returns screenResponse of type list of screens   -All the screens of user input theatreId
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	 
	@GetMapping("screen/theatre/{id}")
	public ResponseEntity<List<Screen>> getAllScreens(@PathVariable("id") int theatreId)throws OnlineMovieException
	{
		
		List<Screen> list= screenService.getAllScreens(theatreId);
		if(list==null)
		{
			msg="Theatre Id not exixts";
			logger.info(msg);		
			screenResponse =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			msg=" Screen List::"+list;
			logger.info(msg);
			screenResponse =new ResponseEntity<List<Screen>>(list,HttpStatus.OK);
		}
		return screenResponse;
		}
	/*********************************************************************************************************************************
	 * Method: showAllScreens
     *Description: To get all the screens
	 * @returns screenResponse of type list of screens   - All the screens 
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@GetMapping("screen")
	public ResponseEntity<List<Screen>> showAllScreens()
	{
		List<Screen> list= screenService.showAllScreens();
		return new ResponseEntity<List<Screen>>(list,HttpStatus.OK);
	}
	
	
	
}
