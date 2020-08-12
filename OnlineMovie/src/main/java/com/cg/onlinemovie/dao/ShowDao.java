package com.cg.onlinemovie.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.cg.onlinemovie.entity.Show;

/*************************************************************************************************************************
 * @author     : BhavaniThatipamula
 * Description : It is a Dao interface which extends the JPA repository of show which is capable to perform all crud 
 *               operations of show. 
 * Version     : 1.0 
 * Created Date: 12-AUG-2020
 *************************************************************************************************************************/
@Repository
public interface ShowDao extends JpaRepository<Show,Integer>{

	@Query("select e from Show e where e.movie.movieId=:movieId")
	public List<Show> existsByMovieId(@Param("movieId") int movieId);
		
}
