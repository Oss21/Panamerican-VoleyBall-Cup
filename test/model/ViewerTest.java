package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

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
	public void inorderTest() {
		setupEscenary1();
		Viewer a = new Viewer();
		a.setId("A0025");
		Viewer b = new Viewer();
		b.setId("A0028");
		Viewer c = new Viewer();
		c.setId("A0020");
		Viewer d = new Viewer();
		d.setId("A0019");
		ArrayList<Viewer> s =  new ArrayList<Viewer>();
		viewer.add(a);
		viewer.add(b);
		viewer.add(c);
		viewer.add(d);
		
		viewer.inorder(s);
		
		assertEquals(d, s.get(0));
		assertEquals(c, s.get(1));
		assertEquals(viewer, s.get(2));
		assertEquals(a, s.get(3));
		assertEquals(b, s.get(4));		
	}
	
	@Test
	public void checkCompareTo() {
		setupEscenary1();
		Viewer a = new Viewer();
		a.setId("A0023");
		Viewer c = new Viewer();
		c.setId("A0025");
		Viewer d = new Viewer();
		d.setId("A0020");
		assertTrue(viewer.compareTo(a)== 0);
		assertTrue(viewer.compareTo(c) < 0);
		assertTrue(viewer.compareTo(d) > 0);
		
	}
}
