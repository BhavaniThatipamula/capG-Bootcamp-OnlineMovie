package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.City;


import com.cg.sprint.entity.Movies;



import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.exceptions.AdminAccountNotFoundException;
import com.cg.sprint.service.AdminServiceInterface;
@RequestMapping("/admin")
@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {	
	@Autowired
	private AdminServiceInterface adminservice;
	//Admin Details
	@GetMapping("/admin-validation/{username}/{password}")
	public ResponseEntity<Admin> aLogin(@PathVariable("username") String uname, @PathVariable("password") String pwd){
		Admin auth = adminservice.aLogin(uname, pwd);
		ResponseEntity<Admin> responseEntity = null;
	    if (auth == null) {
	        throw new AdminAccountNotFoundException();
	    }
	    responseEntity = new ResponseEntity<Admin>(auth,HttpStatus.OK);
	    return responseEntity;
	}
	
	    //add city	
		@PostMapping("/addcity")
	    public City addCity(@Valid @RequestBody City c)
	    {
	   	 return adminservice.save(c);
	    }
		
		//add theater
		@PostMapping("/addtheatre")
	    public Theatre addTheatre(@Valid @RequestBody Theatre t)
	    {
	   	 return adminservice.save(t);   	
	    }
		
		//add movie
		@PostMapping("/addmovie")
	    public Movies addMovie(@Valid @RequestBody Movies m)
	    {
	   	 return adminservice.save(m);
	    }
		
		//add show
		@PostMapping("/addshow")
	    public Shows addShow(@Valid @RequestBody Shows s)
	    {
	   	 return adminservice.save(s); 	
	    }
		
		//displaying city list
		@GetMapping("/cityList")
		public List<City> cityList()
		{		
			return adminservice.getCityList();
		}
		
		//displaying theater list
		@GetMapping("/theatreList")
		public List<Theatre> theatreList()
		{		
			return adminservice.getTheatreList();
		}
		//displaying movies
		@GetMapping("/moviesList")
		public List<Movies> movieList()
		{		
			return adminservice.getMovieList();
		}
		
		//displaying shows
		@GetMapping("/showsList")
		public List<Shows> showList()
		{
			return adminservice.getShowList();
		}
		
		//updating cities
		@PutMapping("/update_cities")
		public String updateCity(@RequestBody City c) 
		{		
			return adminservice.updateCity(c);
		}
		
		//updating theaters
		@PutMapping("/update_theatres")
		public String updateTheatre(@RequestBody Theatre t) 
		{	
			return adminservice.updateTheatre(t);
		}
		
		//updating movies
		@PutMapping("/update_movies")
		public String updateMovies(@RequestBody Movies m)
		{	
			return adminservice.updateMovies(m);
		}
		
		//updating shows
		@PutMapping("/update_shows")
		public String updateShows(@RequestBody Shows s)
		{	
			return adminservice.updateShows(s);
		}
		
		//Deleting city by id
		@DeleteMapping("/removeCity/{sno}")
	    public String removeCity(@PathVariable int sno)
	    {
	   	 adminservice.removeCity(sno);
	   	 return "City Details Removed";
	    }
		
		//Deleting theater by id
		@DeleteMapping("/removeTheatre/{theatre_id}")
	    public String removeTheatre(@PathVariable int theatre_id)
	    {
	   	 adminservice.removeTheatre(theatre_id);
	   	 return "Theatre Details Removed";
	    }
		
		//Deleting movie by id
		@DeleteMapping("/removeMovie/{movie_id}")
	    public String removeMovie(@PathVariable int movie_id)
	    {
	   	 adminservice.removeMovie(movie_id);
	   	 return "Movie Details Removed";
	    }
		
		//Deleting show by id
		@DeleteMapping("/removeShow/{sno}")
	    public String removeShow(@PathVariable int sno)
	    {
	   	 adminservice.removeShow(sno);
	   	 return "Show Details Removed";
	    }
	}