package com.cg.onlinemovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinemovie.dao.ShowDao;
import com.cg.onlinemovie.entity.Show;
import com.cg.onlinemovie.exception.OnlineMovieException;


@Service
public class ShowServiceImpl implements ShowService{
	
	/****************************************************************************************************************************
	 * @author            BhavaniThatipamula
	 * Description        It is a service implementation which is implemented by the class having business logic for add,delete           
	 *                    functionalities of show service interface
	 * Version            1.0 
	 * Created Date       12-AUG-2020
	 *****************************************************************************************************************************/
	@Autowired
	ShowDao showDao;

	/*********************************************************************************************************************************
	 * Method: addShow
     *Description: To add a show based on user input of showId / showName / start time and end time 
	 * @returns  show - show is added for particular movieId.
	 * @throws user defined Exception - when movieId not found
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
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


	/*********************************************************************************************************************************
	 * Method: deleteShow
     *Description: To delete a show based on user input of showId throws an exception if the showId not present 
	 * @returns show - show is deleted for user input show Id.
	 * @throws user defined Exception(ShowId not found) when showId not found
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
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

	/*********************************************************************************************************************************
	 * Method: getAllShows
     *Description: To get all the shows based on user input of movie Id 
	 * @returns screenResponse of type list of shows - list of shows can be  printed for the particular movie Id.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	
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
	/*********************************************************************************************************************************
	 * Method: showAllShows
     *Description: To show all the shows.
	 * @returns list of show- All the shows irrespective of the movieId will be displayed.
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/
	@Override
	public List<Show> showAllShows() {
	
		List<Show> list=showDao.findAll();
		return list;
	}

	/*********************************************************************************************************************************
	 * Method: getShow
     *Description: To get the show details for particular showId.
	 * @returns list of show-  Show details can be printed
                *Created By                              - BhavaniThatipamula
                *Created Date                            - 12-AUG-2020                           	 
	 **********************************************************************************************************************************/

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
