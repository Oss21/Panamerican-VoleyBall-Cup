package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ViewerTest {
	
	private Viewer viewer;
	
	private void setupEscenary1(){
		String id = "A0023";
		String first_name = "Oscar";
		String last_name = "Riascos";
		String email = "osvan20@gmail.com";
		String gender = "Male";
		String country = "Colombia";
		String photo = "url";
		String birthday = "29/08/2018";
		
		viewer = new Viewer(id, first_name, last_name, email, gender, country, photo, birthday);
	}
	
	@Test
	public void checkGetMethods() {
		setupEscenary1();
		//Prueba si el metodo devuelve el id
		assertEquals("A0023", viewer.getId());
		assertEquals("Oscar", viewer.getFirst_name());
		assertEquals("Riascos", viewer.getLast_name());
		assertEquals("osvan20@gmail.com", viewer.getEmail());
		assertEquals("Male",viewer.getGender());
		assertEquals("Colombia",viewer.getCountry());
		assertEquals("url", viewer.getPhoto());
		assertEquals("29/08/2018", viewer.getBirthday());

	}
	
	
	@Test
	public void checkAddViewer() {
		setupEscenary1();
		Viewer vIzquierda = new Viewer();
		vIzquierda.setId("A0021");
		Viewer vDerecha = new Viewer();
		vDerecha.setId("A0025");
		viewer.add(vDerecha);
		viewer.add(vIzquierda);
		
		assertTrue(viewer.getLeftViewer() != null);
		assertTrue(viewer.getRightViewer() != null);
	}
	
	@Test
	public void searchTest() {
		setupEscenary1();
		String id = viewer.getId();
		assertTrue(viewer.search(id) != null);
		
	}
	
	@Test 
	public void testSearch() {
		setupEscenary1();
		
	}
}
