package com.cg.sprint.admin;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.sprint.dao.CityDao;
import com.cg.sprint.dao.MoviesDao;
import com.cg.sprint.dao.ShowsDao;
import com.cg.sprint.dao.TheatreDao;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Movies;
import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.service.AdminService;
@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminEurekaApplicationTests {	
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
    private CityDao cityDao;
	@InjectMocks
	private AdminService adminService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetCityList(){
		List<City> cityList = new ArrayList<City>();
		cityList.add(new City(11,101,"hyderabad"));
		cityList.add(new City(21,102,"pune"));
		when(cityDao.findAll()).thenReturn(cityList);
		List<City> result = cityDao.getCityList();
		assertEquals(2, cityList.size());
	}
	@Test
	public void testaddCity() {
		City city=new City(12, 112, "malkajgiri");
		city.setSno(12);
		city.setCityId(112);
		city.setCityNames("malkajgiri");
		cityDao.save(city);
	}
	@Test
	public void updateCity() {
		City city = new City(11,26,"mvrmall");
		cityDao.findById(11);
		cityDao.save(city);
	   verify(cityDao, Mockito.times(1)).save(city);
	}
	@Test
	public void deleteCity(){
	City city = new City(2,23,"hyderabad");
	cityDao.deleteById(2);
	verify(cityDao, times(1)).deleteById(2);
	}
	@Mock
	private MoviesDao movieDao;
	@InjectMocks
	private AdminService adminService1;
	private Optional<Movies> Movies;
	@Before
	public void setup1(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetMovieList(){
		List<Movies> MovieList = new ArrayList<Movies>();
		MovieList.add(new Movies(11,"mvrmall","hyderabad"));
		MovieList.add(new Movies(21,"balaji","pune"));
		when(movieDao.findAll()).thenReturn(MovieList);
		List<Movies> result = movieDao.getMovieList();
		assertEquals(2, MovieList.size());
	}
	@Test
	public void testaddMovie() {
		Movies movie=new Movies(12,"balaji","malkajgiri");
		movie.setMovieId(12);
		movie.setTheatres("balaji");
		movie.setMovie("malkajgiri");
		movieDao.save(movie);
	}
	@Test
	public void updateMovies() {
		Movies movie = new Movies(65,"grfdestr","mvrmall");
		movieDao.findById(65);
		movieDao.save(movie);
	   verify(movieDao, Mockito.times(1)).save(movie);
	}
	@Test
	public void deleteMovies(){
	Movies movies = new Movies(3,"Rajivgandi","hyderabad");
	movieDao.deleteById(3);
	verify(movieDao, times(1)).deleteById(3);
	}	
	@Mock
private TheatreDao theatreDao;
@InjectMocks
private AdminService adminService2;
@Before
public void setup2(){
	MockitoAnnotations.initMocks(this);
}
@Test
public void testGetTheatreList(){
	List<Theatre> TheatreList = new ArrayList<Theatre>();
	TheatreList.add(new Theatre(11,"srinivasa","siddipet"));
	TheatreList.add(new Theatre(24,"asian","pune"));
	when(theatreDao.findAll()).thenReturn(TheatreList);
	List<Theatre> result = theatreDao.getTheatreList();
	assertEquals(2, TheatreList.size());
}
@Test
public void updateTheatre() {
	Theatre theatre = new Theatre(35,"grfdestr","mvrmall");
	theatreDao.findById(35);
	theatreDao.save(theatre);
   verify(theatreDao, Mockito.times(1)).save(theatre);
}

@Test
public void deleteTheatre(){
	Theatre theatre = new Theatre(11,"hyderabad","ranam");
	theatreDao.deleteById(11);
    verify(theatreDao, times(1)).deleteById(11);
}
@Test
public void testaddTheatre() {
	Theatre theatre=new Theatre(18,"qwe","malkajgiri");
	theatre.setTheatreId(18);
	theatre.setTheatreName("qwe");
	theatre.setCityName("malkajgiri");
	theatreDao.save(theatre);
}
@Mock
private ShowsDao showsDao;
@InjectMocks
private AdminService adminService3;
@Before
public void setup3(){
	MockitoAnnotations.initMocks(this);
}
@Test
public void testGetShowsList(){
	List<Shows> showList = new ArrayList<Shows>();
	showList.add(new Shows(24,"asian","matniee"));
	when(showsDao.findAll()).thenReturn(showList);
	List<Shows> result = showsDao.getShowList();
	assertEquals(1, showList.size());
}
@Test
public void deleteShows(){
Shows shows = new Shows(2,"Rajivgandi","hyderabad");
showsDao.deleteById(2);
verify(showsDao, times(1)).deleteById(2);
}
@Test
public void updateShows() {
	Shows shows = new Shows(25,"grfdestr","mvrmall");
	showsDao.findById(25);
	showsDao.save(shows); 
   verify(showsDao, Mockito.times(1)).save(shows);
}
@Test
public void testaddShows() {
	Shows shows=new Shows(12,"", "malkajgiri");
	shows.setSno(12);
	shows.setTimings("3:40am");
	shows.setShow("morning");
	showsDao.save(shows);
}
}