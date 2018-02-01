package test_strutturali;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import myclasses.Bagaglio;


public class BagaglioTest {

	Bagaglio b;
	
	@Before
	public void setUp() throws Exception {
		b = new Bagaglio(76, "A Mano", "35cm x 55cm x 25cm", 17.00);
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(b);
		assertEquals(76, b.getId_extra());
		assertEquals(17.00, b.getCosto(), 0.00);
	}
	
	@Test
	public void testInfoBagaglio() {
		b.printInfoExtra();
	}


}
