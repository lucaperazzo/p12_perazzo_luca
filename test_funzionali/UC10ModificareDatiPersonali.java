package test_funzionali;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import myclasses.Utente;
import system.Sistema;

public class UC10ModificareDatiPersonali {

	Utente u1;
	Sistema s;

	@Before
	public void setUp() throws Exception {
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		s = new Sistema();
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: l'utente riesce a modificare i dati che gli interessano
	@Test
	public void UC10test1() {
		//vengono mostrate le informazioni personali all'utente
		u1.visualizzaProfilo();
		//le modifiche vengono accettate dal sistema
		assertTrue(u1.modificaDati("Simone", "Verdi", "pass1234", "simoneverdi@gmail.com"));
		//i dati di nome, cognome, password e email sono stati cambiati
		u1.visualizzaProfilo();
	}
	
	//Scenario alternativo 4a. : l'utente decide di annullare la modifica dei propri dati
	@Test
	public void UC10test2() {
		//vengono mostrate le informazioni personali all'utente
		u1.visualizzaProfilo();
		//l'utente annulla e non viene modificato alcun dato
		assertEquals("Mario", u1.getNome());
		assertEquals("Rossi", u1.getCognome());
		assertEquals("psswrd", u1.getPassword());
		assertEquals("mariorossi@gmail.com", u1.getEmail());
	}
	
	//Scenario alternativo 6a. : il sistema non convalida uno o più dati e non permette la modifica all'utente
	@Test
	public void UC10test3() {
		//vengono mostrate le informazioni pesonali all'utente
		u1.visualizzaProfilo();
		//le modifiche non vengono accettate dal sistema
		assertFalse(u1.modificaDati("", "Verdi", "", "simoneverdi@gmail.com"));
		//i dati di nome, cognome, password e email sono uguali ai precedenti
		assertEquals("Mario", u1.getNome());
		assertEquals("Rossi", u1.getCognome());
		assertEquals("psswrd", u1.getPassword());
		assertEquals("mariorossi@gmail.com", u1.getEmail());
		u1.visualizzaProfilo();
	}

}
