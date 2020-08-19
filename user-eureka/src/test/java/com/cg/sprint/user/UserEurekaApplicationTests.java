package com.cg.sprint.user;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import com.cg.sprint.dao.CityDao;
import com.cg.sprint.dao.LanguagesDao;
import com.cg.sprint.dao.MoviesDao;
import com.cg.sprint.dao.PaymentDao;
import com.cg.sprint.dao.SeatsDao;
import com.cg.sprint.dao.ShowsDao;
import com.cg.sprint.dao.TheatreDao;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Languages;
import com.cg.sprint.entity.Movies;
import com.cg.sprint.entity.Payments;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.service.UserService;
@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserEurekaApplicationTests {
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
    private CityDao cityDao;
	@InjectMocks
	private UserService userService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCityNames(){
		List<City> cityNames = new ArrayList<City>();
		cityNames.add(new City(11,101,"hyderabad"));
		cityNames.add(new City(21,102,"pune"));
		when(cityDao.findAll()).thenReturn(cityNames);
		List<City> result = cityDao.getCityNames();
		assertEquals(2, cityNames.size());
	}
	@Mock
	private MoviesDao movieDao;
	@InjectMocks
	private UserService userService1;
	private Optional<Movies> Movies;
	@Before
	public void setup1(){
		MockitoAnnotations.initMocks(this);
	}
		@Test
	public void testGetMovieNames(){
		List<Movies> Movie = new ArrayList<Movies>();
		Movie.add(new Movies(11,"mvrmall","hyderabad"));
		Movie.add(new Movies(21,"balaji","pune"));
		when(movieDao.findAll()).thenReturn(Movie);
		List<Movies> result = movieDao.findAll();
		assertEquals(2, Movie.size());
	}
		@Mock
		private TheatreDao theatreDao;
		@InjectMocks
		private UserService userService2;
		@Before
		public void setup2(){
			MockitoAnnotations.initMocks(this);
		}
		@Test
		public void testTheatreNames(){
			List<Theatre> TheatreNames = new ArrayList<Theatre>();
			TheatreNames.add(new Theatre(11,"srinivasa","siddipet"));
			TheatreNames.add(new Theatre(24,"asian","pune"));
			when(theatreDao.findAll()).thenReturn(TheatreNames);
			List<Theatre> result = theatreDao.findAll();
			assertEquals(2, TheatreNames.size());
		}
		@Mock
		private ShowsDao showsDao;
		@InjectMocks
		private UserService userService3;
		@Before
		public void setup3(){
			MockitoAnnotations.initMocks(this);
		}
		@Test
		public void testGetShowsNames(){
			List<Shows> showNames = new ArrayList<Shows>();
			showNames.add(new Shows(24,"asian","matniee"));
			when(showsDao.findAll()).thenReturn(showNames);
			List<Shows> result = showsDao.getShows();
			assertEquals(1, showNames.size());
		}
		@Mock
		private SeatsDao seatsDao;
		@InjectMocks
		private UserService userService4;
		@Before
		public void setup4(){
			MockitoAnnotations.initMocks(this);
		}
		@Test
		public void testGetAllSeats(){
			List<Seats> seatList = new ArrayList<Seats>();
			seatList.add(new Seats(11,"gold",101,32));
			when(seatsDao.findAll()).thenReturn(seatList);
			List<Seats> result = seatsDao.findAll();
			assertEquals(1,seatList.size());
		}
		
		@Test
		public void updateSeats() {
			Seats seats = new Seats(25,"gold",67,112);
			seatsDao.findById(25);
			seatsDao.save(seats);
		   verify(seatsDao, Mockito.times(1)).save(seats);
		}
		@Test
		public void deleteSeats(){
			Seats seats = new Seats(11,"gold",101,32);
			seatsDao.deleteById(11);
		    verify(seatsDao, times(1)).deleteById(11);
		}
		@Mock
		private LanguagesDao languagesDao;
		@InjectMocks
		private UserService userService5;
		@Before
		public void setup5(){
			MockitoAnnotations.initMocks(this);
		}
		@Test
		public void testGetAllLanguages(){
			List<Languages> LanguagesList = new ArrayList<Languages>();
			LanguagesList.add(new Languages(11,"telugu"));
			//seatList.add(new Seats(21,102,"pune",21,87));
			when(languagesDao.findAll()).thenReturn(LanguagesList);
			List<Languages> result = languagesDao.findAll();
			assertEquals(1,LanguagesList.size());
		}
		
		@Mock
		private  PaymentDao paymentDao;
		@InjectMocks
		private UserService UserService6;
		@Before
		public void setup6(){
			MockitoAnnotations.initMocks(this);
		}
		@Test
		public void testaddPayments() {
			Payments payments=new Payments(12,34,112,65, "malkajgiri",78,"src");
			payments.setBookingId(1432);
			payments.setAccountNo(76512);
			payments.setMoneyCollected(500);
			payments.setSeatsBooked(2);
			payments.setSeatType("bolcony");
			payments.setRefund(250);
			paymentDao.save(payments);
		}
		@Test
		public void updatePayment() {
			Payments payment=new Payments(29,54,786,12,"sri",87,"opi");
			paymentDao.findById(12);
			paymentDao.save(payment);
			verify(paymentDao, Mockito.times(1)).save(payment);
		}
		@Test
		public void deletePayment(){
			Payments payment = new Payments(32,22,11,112,"loan",82,"houseloan");
			paymentDao.deleteById(32);
		    verify(paymentDao, times(1)).deleteById(32);
		}
		//user

}			


