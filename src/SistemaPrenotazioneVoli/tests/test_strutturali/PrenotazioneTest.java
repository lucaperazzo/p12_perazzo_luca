package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Prenotazione;
import myclasses.Volo;

public class PrenotazioneTest {
	
	Prenotazione p1, p2;
	Volo v1;
	
	@Before
	public void setUp() throws Exception {
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		p1 = new Prenotazione(2, v1);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(p1);
		assertEquals(2, p1.getNumPasseggeri());
		assertEquals(v1, p1.getVolo());
	}
	
	@Test 
	public void testModificaPrenotazione() {
		Volo v2 = new Volo(644, "Milano", "Londra", 80, 2.00, "12.00", "14.00", 44.00, 400.00, "EasyJet");
		assertTrue(p1.modificaPrenotazione(v2));
		assertEquals(v2, p1.getVolo());
		v1.setPostiDisponibili(1);
		assertFalse(p1.modificaPrenotazione(v1));
	}
	
	@Test
	public void testAddExtra() {
		assertTrue(p1.scegliBagaglio("A Mano"));
		assertTrue(p1.scegliBagaglio("In Stiva"));
		assertFalse(p1.scegliBagaglio(""));
		
		assertTrue(p1.scegliAssicurazione("Infortuni"));
		assertTrue(p1.scegliAssicurazione("Annullamento"));
		assertFalse(p1.scegliAssicurazione(""));
		
		assertTrue(p1.scegliPosto(8, 'F'));
		
		//Ho aggiunto alla prenotazione 5 extra: 2 bagagli, 2 assicurazioni e un posto
		assertEquals(5, p1.getListExtra().size());
		
		p1.printInfoPrenotazione();		
	}

}
