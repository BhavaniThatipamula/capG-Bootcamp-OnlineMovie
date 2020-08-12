package com.cg.onlinemovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinemovie.dao.ShowDao;
import com.cg.onlinemovie.entity.Show;
import com.cg.onlinemovie.exception.OnlineMovieException;


@Service
public class ShowServiceImpl implements ShowService{
	
	@Autowired
	ShowDao showDao;

	@Override
	public Show addShow(int movieId, Show show) throws OnlineMovieException {
		
		Show addedShow =null;
		
		List<Show> templist=showDao.existsByMovieId(movieId);
		if(templist!=null)
		{
			addedShow=showDao.saveAndFlush(show);
		}
		else
		{
			throw new OnlineMovieException("Movie Id not found");
		}
		 
		return addedShow;
	}

	@Override
	public Show deleteShow(int movieId, int showId) throws OnlineMovieException {
		 List<Show> templist=showDao.existsByMovieId(movieId);
		 Show show=null;
		 show=showDao.findById(showId).get();
		 if(templist!=null)
		 {
			 if(showDao.existsById(showId))
			 { 
				 showDao.deleteById(showId);
			 }
			 else
			 {
				 throw new OnlineMovieException("Show Id not found");
			 }
		 }
		 else
		 {
			 throw new OnlineMovieException("Movie ID not found");
		 }
		return show;
	}

	@Override
	public List<Show> getAllShows(int movieId) throws OnlineMovieException {
		
		List<Show> showlist;
		
		showlist=showDao.existsByMovieId(movieId);
		if(showlist==null)
		{
			throw new OnlineMovieException("Movie Id not found");
		}
		else
		{
			return showlist;
		}
		
	}

	
	@Override
	public List<Show> showAllShows() {
	
		List<Show> list=showDao.findAll();
		return list;
	}

	@Override
	public Show getShow(int showId) throws OnlineMovieException {
		 Show temp=showDao.findById(showId).get();
		 if(temp==null)
		 {
			 throw new OnlineMovieException("Show Id not found");
		 }
		return temp;
	}



}
