package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Utente;
import system.Sistema;

public class UC3Autenticarsi {

	Sistema s;
	Utente u1;
	
	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		s.addUtente(u1);
	}

	//Scenario principale: l'utente riesce ad autenticarsi
	@Test
	public void UC3test1() {
		//il login va a buon fine e l'utente è autenticato
		assertTrue(s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword()));
		assertTrue(s.getListaUtenti().get(0).isAutenticato());
	}
	
	//Scenario alternativo 3a. : l'utente decide di annullare la procedura
	@Test
	public void UC3test2() {
		//l'utente non effettua il login
		assertFalse(s.getListaUtenti().get(0).isAutenticato());
	}
	
	//Scenario alternativo 4a. : i dati inseriti dall'utente non sono corretti
		@Test
		public void UC3test3() {
			//il login non va a buon fine e l'utente non è autenticato
			assertFalse(s.login(s.getListaUtenti().get(0).getEmail(), s.getListaUtenti().get(0).getPassword()));
			assertFalse(s.getListaUtenti().get(0).isAutenticato());
		}

}
