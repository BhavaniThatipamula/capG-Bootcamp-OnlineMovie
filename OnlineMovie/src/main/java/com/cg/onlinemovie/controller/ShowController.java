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

	@Autowired
	 ShowService showService;
	
	Logger logger = LoggerFactory.getLogger(OnlineMovieApplication.class);
	String msg;
	
	ResponseEntity showResponse=null;
	
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
	
	
	@GetMapping("show")
	public ResponseEntity<List<Show>> showAllShows()
	{
		List<Show> show=showService.showAllShows();
		return new ResponseEntity<List<Show>>(show,HttpStatus.OK);
	}

}
