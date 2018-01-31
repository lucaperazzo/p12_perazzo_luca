package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Utente;
import system.Sistema;

public class UC11Deautenticarsi {

	Sistema s;
	Utente u1;
	
	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: l'utente riesce a deautenticarsi
	@Test
	public void UC11test1() {
		//l'utente riesce ad eseguire il logout correttamente
		assertTrue(s.logout(s.getListaUtenti().get(0)));
		assertFalse(s.getListaUtenti().get(0).isAutenticato());
	}
	
	//Scenario alternativo 3a. : l'utente decide di annullare l'operazione di logout
	@Test
	public void UC11test2() {
		//l'utente decide di non deautenticarsi, rimane quindi autenticato nel sistema
		assertTrue(s.getListaUtenti().get(0).isAutenticato());
	}
	
}
