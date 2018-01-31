package test_strutturali;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import myclasses.Abbonamento;
import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;
import system.Sistema;

public class SistemaTest {

	Sistema s;
	Utente u1;
	Abbonamento a1;
	Volo v1;
	Prenotazione p;
	
	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		a1 = new Abbonamento(101, 300.00, 1500.00, "RyanAir");	
		p = new Prenotazione(2, v1);
		
		s.addAbbonamento(a1);
		s.addVolo(v1, 10);
		s.addUtente(u1);
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(s);
		assertNotNull(s.getListaAbbonamenti());
		assertNotNull(s.getListaUtenti());
		assertNotNull(s.getListaVoli());
	}
	
	@Test
	public void testLoginLogout() {
		Utente u2 = new Utente(2, "Luca", "Perazzo", "lucaperazzo", "psswrd", "lucaperazzo@gmail.com");
		assertTrue(s.login(u1.getUsername(), u1.getPassword()));
		assertFalse(s.login(u1.getUsername(), u1.getPassword()));
		assertFalse(s.login(u2.getUsername(), u2.getPassword()));
		assertFalse(s.login(u1.getUsername(), u1.getCognome()));
		
		assertTrue(s.logout(u1));
		assertFalse(s.logout(u1));
		assertFalse(s.logout(u2));
		
		//rimuovo l'utente dalla lista
		s.getListaUtenti().remove(0);
		assertFalse(s.login(u1.getUsername(), u1.getPassword()));
		assertFalse(s.logout(u1));
	}
	
	@Test
	public void testRicercaVolo() {
		Calendar data = Calendar.getInstance();
		data.set(2018, 1, 4);
		s.ricercaVolo("Roma", "Madrid", data, 3);
		s.ricercaVolo("Milano", "Madrid", data, 3);
		s.ricercaVolo("Roma", "Milano", data, 3);
		s.ricercaVolo("Roma", "Madrid", data, 50);
		data.set(2017, 0, 29);
		s.ricercaVolo("Roma", "Madrid", data, 3);
	}

	@Test
	public void testPrenotaVolo() {
		assertTrue(s.prenotaVolo(u1, p, "PayPal"));
		assertFalse(s.prenotaVolo(u1, p, "ApplePay"));
	}
	
	@Test
	public void testAbbonamenti(){
		s.visualizzaAbbonamenti();
		assertTrue(s.scegliAbbonamento(u1, a1, "Carta"));
		assertFalse(s.scegliAbbonamento(u1, a1, "ApplePay"));
		s.getListaAbbonamenti().remove(0);
		s.visualizzaAbbonamenti();
	}
	
	@Test
	public void testScriviRecensioni() {
		assertTrue(s.scriviRecensione(u1, v1, 4, "..."));
	}
	
}
