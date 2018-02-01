package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Abbonamento;
import myclasses.Pagamento;
import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;

public class UtenteTest {
	
	Utente u1;
	Prenotazione p1;
	Pagamento pagamento;
	Abbonamento a1;
	Volo v1;
	
	@Before 
	public void setUp() throws Exception{
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		v1.setData(2018, 0, 20);
		v1.addRecensione(u1, 4, "...");
		p1 = new Prenotazione(2, v1);
		pagamento = new Pagamento();
		a1 = new Abbonamento(101, 300.00, 1500.00, "RyanAir");	
		
		u1.getListaPrenotazioni().add(p1);
		u1.getAbbonamentiPosseduti().add(a1);
		u1.getPagamentiEffettuati().add(pagamento);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(u1);
		assertEquals(1, u1.getId_utente());
		assertEquals("Mario", u1.getNome());
		assertEquals("Rossi", u1.getCognome());
		assertEquals("mariorossi", u1.getUsername());
		assertEquals("psswrd", u1.getPassword());
		assertEquals("mariorossi@gmail.com", u1.getEmail());
	}
	
	@Test
	public void testAddMiglia(){
		u1.addMiglia(500.00);
		assertEquals(500.00, u1.getMigliaAccumulate(), 0.00);
	}
	
	@Test
	public void testVisualizzaProfilo(){
		u1.visualizzaProfilo();
		v1.getListaRecensioni().remove(0);
		u1.visualizzaProfilo();
		v1.setData(2019, 6, 20);
		u1.visualizzaProfilo();
		u1.getListaPrenotazioni().remove(0);
		u1.getAbbonamentiPosseduti().remove(0);
		u1.getPagamentiEffettuati().remove(0);
		u1.visualizzaProfilo();
	}
	
	@Test
	public void testModificaDati(){
		assertTrue(u1.modificaDati("Simone", "Verdi", "pass", "simoneverdi@gmail.com"));
		assertFalse(u1.modificaDati("", "Verdi", "pass", "simoneverdi@gmail.com"));
		assertFalse(u1.modificaDati("Simone", "", "pass", "simoneverdi@gmail.com"));
		assertFalse(u1.modificaDati("Simone", "Verdi", "", "simoneverdi@gmail.com"));
		assertFalse(u1.modificaDati("Simone", "Verdi", "pass", ""));
	}
	
	@Test
	public void testAutenticazione(){
		u1.setAutenticato(true);
		assertTrue(u1.isAutenticato());
	}
	
	@Test
	public void testRimuoviPrenotazione() {
		assertTrue(u1.destroyPrenotazione(p1));
		assertFalse(u1.destroyPrenotazione(p1));
	}
	
	@Test
	public void testVisualizzaVoliDaRecensire() {
		u1.visualizzaVoliDaRecensire();
		Utente u2 = new Utente(1, "Simone", "Verdi", "simoneverdi", "psswrd", "simoneverdi@gmail.com");
		v1.getListaRecensioni().get(0).setUtente(u2);
		u1.visualizzaVoliDaRecensire();
		v1.setData(2018, 4, 1);
		u1.visualizzaVoliDaRecensire();
	}
	

}
