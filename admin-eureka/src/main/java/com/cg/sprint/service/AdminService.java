package com.cg.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.cg.sprint.dao.AdminDao;
import com.cg.sprint.dao.CityDao;

import com.cg.sprint.dao.MoviesDao;

import com.cg.sprint.dao.ShowsDao;
import com.cg.sprint.dao.TheatreDao;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.City;


import com.cg.sprint.entity.Movies;



import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.exceptions.IdNotFoundException;

@Service
@Transactional
public class AdminService implements AdminServiceInterface  {

	
	@Autowired
	private CityDao city;
	@Autowired
	private TheatreDao theatre;
	@Autowired
	private MoviesDao movie;
	@Autowired
	private ShowsDao shows;
	
	@Autowired
	private AdminDao admin;

	    //Login of an admin  
		@Override
		public Admin aLogin(String uname, String pass) {
			return admin.aLogin(uname, pass);
		}
		
		//To add city
		@Override
		public City save(City c)
	    {
	   	 return city.save(c);
	    }
		
		//To add theater
		@Override
		public Theatre save(Theatre t)
	    {
	   	 return theatre.save(t);
	    }
		
		//To add Movie
		@Override
		public Movies save(Movies m)
	    {
	   	 return movie.save(m);
	    }
		
		//To add show
		@Override
		public Shows save(Shows s)
	    {
	   	 return shows.save(s);
	    }
		
		//To display city list
		@Override
		public List<City> getCityList() {
			return city.getCityList();
		}
		
		//To display movie list
		@Override
		public List<Movies> getMovieList() {
			return movie.getMovieList();
		}
		
		//To display theater list
		@Override
		public List<Theatre> getTheatreList() {
			return theatre.getTheatreList();
		}
		
		//to display show list
		@Override
		public List<Shows> getShowList() {
			return shows.getShowList();
		}
		
		//updating city
		@Override
		public String updateCity(City c) {
		if(city.existsById(c.getSno()))
					{
				city.save(c);
				return "cities were updated successfully!!";
					}
			else {
				return "sorry, cities were not updated";
			}
			
		}
		
		//updating theater
		@Override
		public String updateTheatre(Theatre t) {
			if(theatre.existsById(t.getTheatreId())) {
				theatre.save(t);
				return "theatres were updated successfully!!";
			}
			else {
				return "theatres were not updated";
			}
		}
		
		//updating movies
		@Override
		public String updateMovies(Movies m) {
			if(movie.existsById(m.getMovieId())) {
				movie.save(m);
				return "movies were updated successfully!!";
			}
			else {
				return "movies were not updated";
			}
		}
		
		//updating shows
		@Override
		public String updateShows(Shows s) {
			if(shows.existsById(s.getSno())) {
				shows.save(s);
				return "shows were updated successfully!!";
			}
			else {
				return "shows were not updated";
			}
		}
		
		//To delete city
	    @Override
	    public void removeCity(int sno)
	    {
	    	if(!city.existsById(sno)){
	    		  throw new IdNotFoundException();
	    		}
	   	  city.deleteById(sno);
	    }
	    
	    //To delete theater
	    @Override
	    public void removeTheatre(int theatreId)
	    {
	    	if(!theatre.existsById(theatreId)){
	  		  throw new IdNotFoundException();
	  		}
	   	  theatre.deleteById(theatreId);
	    }
	    
	    //To delete movie
	    @Override
	    public void removeMovie(int movieId)
	    {
	    	if(!movie.existsById(movieId)){
	  		  throw new IdNotFoundException();
	  		}
	   	  movie.deleteById(movieId);
	    }
	    
	    //To delete show
	    @Override
	    public void removeShow(int sno)
	    {
	    	if(!shows.existsById(sno)){
	  		  throw new IdNotFoundException();
	  		}
	   	  shows.deleteById(sno);
	    }
		
	}