package com.cg.onlinemovie.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.cg.onlinemovie.entity.Show;


@Repository
public interface ShowDao extends JpaRepository<Show,Integer>{

	@Query("select e from Show e where e.movie.movieId=:movieId")
	public List<Show> existsByMovieId(@Param("movieId") int movieId);
		
}
