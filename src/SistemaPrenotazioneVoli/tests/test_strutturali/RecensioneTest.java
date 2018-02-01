package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Recensione;
import myclasses.Utente;

public class RecensioneTest {

	Recensione r1;
	Utente u1;
		
	@Before
	public void setUp() throws Exception{
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		r1 = new Recensione(31, "...", u1, 4);
	}
	
	
	@Test
	public void testCostruttore() {
		assertNotNull(r1);
		assertEquals(31, r1.getId_recensione());
		assertEquals("...", r1.getDescrizione());
		assertEquals(u1, r1.getUtente());
		assertEquals(4, r1.getVoto());
		assertFalse(r1.isValidata());
	}
	
	@Test
	public void testInfoRecensione() {
		r1.printInfoRecensione();
	}

}
