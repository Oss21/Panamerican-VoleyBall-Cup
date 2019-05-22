package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompetitorTest {
	
	private Competitor competitor;
	
	
	private void setupEscenary1() {
		String id = "A0023";
		String first_name = "Oscar";
		String last_name = "Riascos";
		String email = "osvan20@gmail.com";
		String gender = "Male";
		String country = "Colombia";
		String photo = "url";
		String birthday = "29/08/2018";
		competitor = new Competitor(id, first_name, last_name, email, gender, country, photo, birthday);
	}
	
	private void setupEscenary2() {
	}
	
	@Test
	public void checkGetMethods() {
		setupEscenary1();
		//Prueba si el metodo devuelve el id
		assertEquals("A0023", competitor.getId());
		assertEquals("Oscar", competitor.getFirst_name());
		assertEquals("Riascos", competitor.getLast_name());
		assertEquals("osvan20@gmail.com", competitor.getEmail());
		assertEquals("Male",competitor.getGender());
		assertEquals("Colombia",competitor.getCountry());
		assertEquals("url", competitor.getPhoto());
		assertEquals("29/08/2018", competitor.getBirthday());
		
		
		
		
	}
	
	
	@Test
	public void checkCompareTo() {
		setupEscenary1();
		Competitor a = new Competitor();
		a.setCountry("Colombia");
		Competitor c = new Competitor();
		c.setCountry("Panama");
		Competitor d = new Competitor();
		d.setCountry("Armenia");
		assertTrue(competitor.compareTo(a)== 0);
		assertTrue(competitor.compareTo(c) < 0);
		assertTrue(competitor.compareTo(d) > 0);
		
	}
	
	
	
	
	
	
	
}
