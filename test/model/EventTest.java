package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EventTest {

	
	private Event ev;
	private Competitor a;
	private Competitor b;
	private Competitor c;
	private Viewer a1;
	private Viewer b1;
	private Viewer c1;
	
	private void setupEscenary1() {
		ev = new Event("VoleyCup");
		a =  new Competitor("01-4984353","Devlin","Croisdall","dcroisdall0@google.com.hk","Male","Brazil","https://robohash.org/nequeautemet.bmp?size=170x170&set=set1","11/19/1989");
		b = new Competitor("97-1208775","Kimble","Hek","khek8@surveymonkey.com","Male","Ukraine","https://robohash.org/fugiatipsamminima.bmp?size=170x170&set=set1","3/21/1979");
		c = new Competitor("68-4066057","Jan","Binner","jbinneri@kickstarter.com","Female","Nicaragua","https://robohash.org/sitquisdignissimos.jpg?size=170x170&set=set1","5/23/2007");
		
		ev.addCompetitor(a);
		ev.addCompetitor(b);
		ev.addCompetitor(c);
	
	}
	
	private void setupEscenary2() {
		ev = new Event("VoleyCup");
		a1 =  new Viewer("01-4984353","Devlin","Croisdall","dcroisdall0@google.com.hk","Male","Brazil","https://robohash.org/nequeautemet.bmp?size=170x170&set=set1","11/19/1989");
		b1 = new Viewer("97-1208775","Kimble","Hek","khek8@surveymonkey.com","Male","Nicaragua","https://robohash.org/fugiatipsamminima.bmp?size=170x170&set=set1","3/21/1979");
		c1 = new Viewer("68-4066057","Jan","Binner","jbinneri@kickstarter.com","Female","Nicaragua","https://robohash.org/sitquisdignissimos.jpg?size=170x170&set=set1","5/23/2007");
		
		ev.addViewer(a1);
		ev.addViewer(b1);
		ev.addViewer(c1);
	}
	
	@Test
	public void checkAddCompetitorAndSearchCompetitor() throws EmptyDateException  {
		setupEscenary1();
		assertNotNull(ev.searchCompetitor(a.getId()));
		assertNotNull(ev.searchCompetitor(b.getId()));
		assertNotNull(ev.searchCompetitor(c.getId()));
		
		//Busqueda por ciudad.
		assertNotNull(ev.searchCompetitorByCountry(a.getCountry()));
		assertNotNull(ev.searchCompetitorByCountry(c.getCountry()));
		assertNotNull(ev.searchCompetitorByCountry(b.getCountry()));
		
	}
	
	@Test
	public void checkAddViewerAndSearchViewer() throws EmptyDateException {
		setupEscenary2();
		assertNotNull(ev.searchViewer(a1.getId()));
		assertNotNull(ev.searchViewer(b1.getId()));
		assertNotNull(ev.searchViewer(c1.getId()));
		ArrayList<Viewer> v = ev.addViewerFromTheSameCountry("Nicaragua");
		//Busqueda por ciudad.
		assertTrue(v.size() == 3);
		assertTrue(v.get(0).getCountry().equals("Nicaragua"));
		assertTrue(v.get(1).getCountry().equals("Nicaragua"));
		assertTrue(v.get(2).getCountry().equals("Nicaragua"));
		
	}
	
	

	
	
	
	

}
