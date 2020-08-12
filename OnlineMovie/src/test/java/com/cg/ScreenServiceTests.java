package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.context.annotation.Role;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinemovie.dao.ScreenDao;
import com.cg.onlinemovie.entity.Screen;
import com.cg.onlinemovie.entity.Theatre;


@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
public class ScreenServiceTests {
	

	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	
	@Mock
	private ScreenDao screenRepo;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddScreen() {
		Theatre theatre=new Theatre(1001,"IMAX","HYDERABAD");
		Screen screen=new Screen();
		screen.setTheatre(theatre);
		screen.setScreenId(2001);
		screen.setScreenName("screen1");
		screen.setNrows(10);
		screen.setNcolumns(20);
		screenRepo.save(screen);
	}
	
	@Test
	public void testDeleteScreen() {
		
		Screen screen=new Screen(2001,"screen1",10,20);
		screenRepo.deleteById(2001);
		verify(screenRepo, Mockito.times(1)).deleteById(2001);
	}
	
	@Test
	public void testGetAllScreens() {
		
		List<Screen> screenList=new ArrayList<Screen>();
		screenList.add(new Screen(1234,"Screen2",10,20));
		when(screenRepo.findAll()).thenReturn(screenList);
		List<Screen> list=screenRepo.findAll();
		assertEquals(1, screenList.size());
		
	}
	
	@Test
	public void testUpdateScreen() {
		
		Screen screen=new Screen(2001,"screen1",100,200);
		
		screenRepo.findById(2001);
		screenRepo.save(screen);
		verify(screenRepo, Mockito.times(1)).save(screen);
	}

}
