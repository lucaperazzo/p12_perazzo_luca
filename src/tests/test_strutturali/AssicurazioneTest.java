package test_strutturali;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import myclasses.Assicurazione;

public class AssicurazioneTest {

	Assicurazione a;
	
	@Before
	public void setUp() throws Exception {
		a = new Assicurazione(402, "Infortuni", "Copertura assicurativa in caso di infortuni durante il viaggio", 28.00);
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(a);
		assertEquals(402, a.getId_extra());
		assertEquals(28.00, a.getCosto(), 0.00);
	}
	
	@Test
	public void testInfoAssicurazione() {
		a.printInfoExtra();
	}


}
