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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineMovieApplication;
import com.cg.onlinemovie.entity.Movie;
import com.cg.onlinemovie.entity.Screen;
import com.cg.onlinemovie.entity.Show;
import com.cg.onlinemovie.exception.OnlineMovieException;
import com.cg.onlinemovie.service.ShowService;

@RestController
@CrossOrigin("*")
public class ShowController {
	
/************************************************************************************************************************************
*          @author          BhavaniThatipamula
*          Description      It is a controller class having Request Mapping functions for functionalities of add,delete for show.
*         Version             1.0
*         Created Date     12-AUG-2020
************************************************************************************************************************************/


    @Autowired
	ShowService showService;
	Logger logger = LoggerFactory.getLogger(OnlineMovieApplication.class);
	String msg;
	ResponseEntity showResponse=null;
	
	/*********************************************************************************************************************************
	 * Method: addShow
     *Description: To add a show based on user input of showId / showName / start time and end time 
	 * @returns screenResponse of type show - show is added for particular movieId.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@PostMapping("show/movie/{id}")
	public ResponseEntity<Show> addShow(@RequestBody Show show,@PathVariable("id") int movieId)throws OnlineMovieException
	{
		Movie movie=new Movie();
		movie.setMovieId(movieId);
		show.setMovie(movie);
		
		List<Show> showList=showService.getAllShows(movieId);
		Show tempShow=showService.addShow(movieId, show);
		if(showList!=null)
		{
			msg="Show added successfully";
			logger.info(msg);
			showResponse=new ResponseEntity<Show>(tempShow,HttpStatus.OK);
		}
		else
		{
			showResponse=new ResponseEntity<Show>(tempShow,HttpStatus.NOT_FOUND);
		}
		return showResponse;
	}

	/*********************************************************************************************************************************
	 * Method: deleteShow
     *Description: To delete a show based on user input of showId throws an exception if the showId not present 
	 * @returns screenResponse of type show - show is deleted for user input show Id.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@DeleteMapping("show/movie/{id}/show/{id1}")
	public ResponseEntity<Show> deleteShow(@PathVariable("id") int movieId, @PathVariable("id1") int showId)throws OnlineMovieException
	{
		Show tempShow=showService.getShow(showId);
		if(tempShow!=null)
		{
			msg="Show deleted successfully!!";
			logger.info(msg);
			showService.deleteShow(movieId, showId);
			showResponse=new ResponseEntity<Show>(tempShow,HttpStatus.OK);
		}
		else
		{
			showResponse =new ResponseEntity<Show>(tempShow,HttpStatus.NOT_FOUND);
		}
		return showResponse;
    }

	/*********************************************************************************************************************************
	 * Method: getAllShows
     *Description: To get all the shows based on user input of movie Id 
	 * @returns screenResponse of type list of shows - list of shows can be  printed for the particular movie Id.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
	@GetMapping("show/movie/{id}")
	public ResponseEntity<List<Show>> getAllShows(@PathVariable("id") int movieId)throws OnlineMovieException
	{	 
		List<Show> showList=showService.getAllShows(movieId);
		if(showList!=null)
		{
			msg="Show List::";
			logger.info(msg);
			showResponse=new ResponseEntity<List<Show>>(showList,HttpStatus.OK);	
		}
		else
		{
			showResponse=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return showResponse;
	}

	/*********************************************************************************************************************************
	 * Method: showAllShows
     *Description: To show all the shows.
	 * @returns screenResponse of type list of show- All the shows irrespective of the movieId will be displayed.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/

	@GetMapping("show")
	public ResponseEntity<List<Show>> showAllShows()
	{
		List<Show> show=showService.showAllShows();
		return new ResponseEntity<List<Show>>(show,HttpStatus.OK);
	}

}
