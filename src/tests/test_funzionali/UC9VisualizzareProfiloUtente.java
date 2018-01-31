package test_funzionali;

import org.junit.Before;
import org.junit.Test;

import myclasses.Utente;
import system.Sistema;

public class UC9VisualizzareProfiloUtente {
	
	Utente u1;
	Sistema s;

	@Before
	public void setUp() throws Exception {
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		s = new Sistema();
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());

	}

	
	//Scenario principale: l'utente può visualizzare i propri dati
	@Test
	public void UC9test1() {
		u1.visualizzaProfilo();
	}

}
