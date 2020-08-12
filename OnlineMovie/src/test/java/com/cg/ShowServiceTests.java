package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinemovie.dao.ShowDao;
import com.cg.onlinemovie.entity.Movie;
import com.cg.onlinemovie.entity.Show;

 
@RunWith(SpringRunner.class)
public class ShowServiceTests {
	
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	
	@Mock
	private ShowDao showRepo;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddShow(){
		
		Movie movie=new Movie(1234,"MAHARSHI");
		Show show=new Show(12345678,"MorningShow");
		show.setMovie(movie);
		showRepo.save(show);
	}
	
	@Test
	public void testDeleteShow(){
		Show show=new Show(12345678,"MorningShow");
		showRepo.deleteById(12345678);
		verify(showRepo, Mockito.times(1)).deleteById(12345678);
		
	}
	
	@Test
	public void testGetAllShows(){
		
		List<Show> showList=new ArrayList<Show>();
		showList.add(new Show(34567890,"Matney"));
		when(showRepo.findAll()).thenReturn(showList);
		List<Show> list=showRepo.findAll();
		assertEquals(1, showList.size());
		
	}

}
