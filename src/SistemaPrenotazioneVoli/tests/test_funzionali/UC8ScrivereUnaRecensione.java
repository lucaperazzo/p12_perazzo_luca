package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;
import system.Sistema;

public class UC8ScrivereUnaRecensione {
	
	Sistema s;
	Utente u1;
	Volo v1;
	Prenotazione p;

	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		v1.setData(2018, 0, 3);
		p = new Prenotazione(2, v1);
		
		u1.getListaPrenotazioni().add(p);
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: l'utente riesce a scrivere la recensione di un viaggio che ha effettuato
	@Test
	public void UC8test1() {	
		//vengono mostrati i voli su cui l'utente può scrivere una recensione
		s.getListaUtenti().get(0).visualizzaVoliDaRecensire();
		//la recensione viene inserita nel sistema in maniera corretta
		assertTrue(s.scriviRecensione(s.getListaUtenti().get(0), v1, 4, "..."));
		assertFalse(v1.getListaRecensioni().isEmpty());
	}
	
	//Scenario alternativo 3a. : non ci sono viaggi che l'utente può recensire
	@Test
	public void UC8test2() {
		//la prenotazione riguarda un volo che dev'essere ancora effettuato
		v1.setData(2018, 3, 3);
		//la lista delle recensioni visualizzate è nulla
		s.getListaUtenti().get(0).visualizzaVoliDaRecensire();
	}
	
	//Scenario alternativo 5a. : l'utente decide di annullare la procedura
	@Test
	public void UC8test3() {
		//vengono mostrati i voli su cui l'utente può scrivere una recensione
		s.getListaUtenti().get(0).visualizzaVoliDaRecensire();
		//l'utente decide di non scrivere la recensione che non verrà quindi inserita nel sistema
		assertTrue(v1.getListaRecensioni().isEmpty());
	}

}
