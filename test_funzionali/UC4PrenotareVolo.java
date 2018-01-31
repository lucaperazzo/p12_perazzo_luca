package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;
import system.Sistema;

public class UC4PrenotareVolo {

	Sistema s;
	Utente u1;
	Volo v1;
	Prenotazione p;

	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		
		s.addVolo(v1, 10);
		s.addUtente(u1);
		//pre condizione utente autenticato nel sistema
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: la prenotazione va a buon fine (nessuna scelta del posto)
	@Test
	public void UC4test1() {
		//dettagli del volo scelto
		s.getListaVoli().get(0).printInfoVolo();
		p = new Prenotazione(3, s.getListaVoli().get(0));
		//aggiunta degli extra
		assertTrue(p.scegliBagaglio("A Mano"));
		assertTrue(p.scegliAssicurazione("Annullamento"));
		//la prenotazione va a buon fine e la prenotazione viene aggiunta a quelle possedute dall'utente
		assertTrue(s.prenotaVolo(s.getListaUtenti().get(0), p, "PayPal"));
		assertEquals(p, s.getListaUtenti().get(0).getListaPrenotazioni().get(0));
	}
	
	//Scenario alternativo 3a. : l'utente decide di annullare la procedura di acquisto dopo aver visionato
	//il volo
	
	@Test
	public void UC4test2(){
		//dettagli del volo scelto
		s.getListaVoli().get(0).printInfoVolo();
		//la prenotazione non viene nemmeno creata
		assertNull(p);
	}
	
	//Scenario alternativo 8a. : la prenotazione va a buon fine e l'utente sceglie il posto
	@Test
	public void UC4test3() {
		//dettagli del volo scelto
		s.getListaVoli().get(0).printInfoVolo();
		p = new Prenotazione(3, s.getListaVoli().get(0));
		//aggiunta degli extra (compreso il posto)
		assertTrue(p.scegliBagaglio("A Mano"));
		assertTrue(p.scegliAssicurazione("Annullamento"));
		assertTrue(p.scegliPosto(8, 'F'));
		//la prenotazione va a buon fine e la prenotazione viene aggiunta a quelle possedute dall'utente
		assertTrue(s.prenotaVolo(s.getListaUtenti().get(0), p, "PayPal"));
		assertEquals(p, s.getListaUtenti().get(0).getListaPrenotazioni().get(0));
	}
		
	//Scenario alternativo 11a. : la prenotazione non va a buon fine a causa del pagamento
	@Test
	public void UC4test4() {
		//dettagli del volo scelto
		s.getListaVoli().get(0).printInfoVolo();
		p = new Prenotazione(3, s.getListaVoli().get(0));
		//aggiunta degli extra
		assertTrue(p.scegliBagaglio("A Mano"));
		assertTrue(p.scegliAssicurazione("Annullamento"));
		//la prenotazione non va a buon fine a causa del metodo di pagamento scelto e l'utente non ha
		//prenotazioni possedute
		assertFalse(s.prenotaVolo(s.getListaUtenti().get(0), p, "ApplePay"));
		assertTrue(s.getListaUtenti().get(0).getListaPrenotazioni().isEmpty());
	}
		

}
