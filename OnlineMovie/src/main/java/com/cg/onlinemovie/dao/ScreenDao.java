package com.cg.onlinemovie.dao;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinemovie.entity.Screen;
 
 
@Repository
public interface ScreenDao extends JpaRepository<Screen,Integer>{
	
	@Query("select e from Screen e where e.theatre.theatreId=:theatreId")
	public List<Screen> existsByTheatreId(@Param("theatreId") int theatreId);

}
