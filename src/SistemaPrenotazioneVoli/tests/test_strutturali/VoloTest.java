package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Utente;
import myclasses.Volo;

public class VoloTest {

	Volo v1;
	Utente u1;
	
	@Before 
	public void setUp() throws Exception{
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		v1.setData(2018, 0, 20);
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(v1);
		assertEquals(642, v1.getId_volo());
		assertEquals("Roma", v1.getPartenza());
		assertEquals("Madrid", v1.getArrivo());
		assertEquals(40, v1.getPostiDisponibili());
		assertEquals(2.30, v1.getDurata(), 0.00);
		assertEquals("11.30",v1.getOrarioPartenza());
		assertEquals("14.00",v1.getOrarioArrivo());
		assertEquals(59.00,v1.getPrezzo(), 0.00);
		assertEquals(500.00,v1.getMiglia(), 0.00);
		assertEquals("RyanAir",v1.getNomeCompagnia());
	}
	
	@Test
	public void testInfoVolo(){
		v1.printInfoVolo();
	}

	
	@Test
	public void testRecensioni(){
		Utente u2 = null;
		assertFalse(v1.addRecensione(u2, 3, "..."));
		assertFalse(v1.addRecensione(u1, 0, "..."));
		assertFalse(v1.addRecensione(u1, 6, "..."));
		assertFalse(v1.addRecensione(u1, 3, ""));
		v1.visualizzaRecensioni();
		assertTrue(v1.addRecensione(u1, 4, "..."));
		v1.visualizzaRecensioni();
	}
	
	//Clono l'oggetto v1 ed eseguo gli stessi test fatti per v1 in testCostruttore()
	@Test
	public void testClone() throws Exception{
		Volo v2 = (Volo)v1.getClone();
		assertNotNull(v2);
		assertEquals(642, v2.getId_volo());
		assertEquals("Roma", v2.getPartenza());
		assertEquals("Madrid", v2.getArrivo());
		assertEquals(40, v2.getPostiDisponibili());
		assertEquals(2.30, v2.getDurata(), 0.00);
		assertEquals("11.30",v2.getOrarioPartenza());
		assertEquals("14.00",v2.getOrarioArrivo());
		assertEquals(59.00,v2.getPrezzo(), 0.00);
		assertEquals(500.00,v2.getMiglia(), 0.00);
		assertEquals("RyanAir",v2.getNomeCompagnia());
	}
	
}
	

