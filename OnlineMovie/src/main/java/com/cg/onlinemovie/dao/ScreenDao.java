package com.cg.onlinemovie.dao;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinemovie.entity.Screen;
 
/*************************************************************************************************************************
 * @author     : BhavaniThatipamula
 * Description : It is a Dao interface which extends the JPA repository of screen which is capable to perform all crud 
 *               operations of screen. 
 * Version     : 1.0 
 * Created Date: 12-AUG-2020
 *************************************************************************************************************************/
@Repository
public interface ScreenDao extends JpaRepository<Screen,Integer>{
	
	@Query("select e from Screen e where e.theatre.theatreId=:theatreId")
	public List<Screen> existsByTheatreId(@Param("theatreId") int theatreId);

}
