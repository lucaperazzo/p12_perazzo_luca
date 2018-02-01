package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Abbonamento;
import myclasses.Utente;
import system.Sistema;

public class UC7ScegliereUnAbbonamento {

	Sistema s;
	Abbonamento a1, a2, a3;
	Utente u1;

	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		a1 = new Abbonamento(101, 300.00, 1500.00, "RyanAir");	
		a2 = new Abbonamento(102, 400.00, 2000.00, "EasyJet");	
		a3 = new Abbonamento(103, 500.00, 3000.00, "Lufthansa");
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		
		s.addAbbonamento(a1);
		s.addAbbonamento(a2);
		s.addAbbonamento(a3);
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: l'utente riesce a comprare un abbonamento
	@Test
	public void UC6test1() {
		//vengono mostrati tutti gli abbonamenti
		s.visualizzaAbbonamenti();
		//vengono mostrati i dettagli dell'abbonamento che l'utente intende acquistare
		s.getListaAbbonamenti().get(1).printInfoAbbonamento();
		//il pagamento va a buon fine
		assertTrue(s.scegliAbbonamento(s.getListaUtenti().get(0), s.getListaAbbonamenti().get(1), "Carta"));
		//l'abbonamento posseduto dall'utente è quello appena acquistato
		assertEquals(s.getListaAbbonamenti().get(1), s.getListaUtenti().get(0).getAbbonamentiPosseduti().get(0));
	}
	
	//Scenario alternativo 4a. : l'utente decide di annullare l'acquisto dell'abbonamento
	@Test
	public void UC6test2() {
		//vengono mostrati tutti gli abbonamenti
		s.visualizzaAbbonamenti();
		//vengono mostrati i dettagli dell'abbonamento che l'utente intende acquistare
		s.getListaAbbonamenti().get(1).printInfoAbbonamento();
		//l'utente annulla quindi nessun abbonamento viene acquistato
		assertTrue(s.getListaUtenti().get(0).getAbbonamentiPosseduti().isEmpty());
	}
	
	//Scenario alternativo 6a. : il pagamento non va a buon fine e l'utente non acquista l'abbonamento
	@Test
	public void UC6test3() {
		s.visualizzaAbbonamenti();
		//vengono mostrati i dettagli dell'abbonamento che l'utente intende acquistare
		s.getListaAbbonamenti().get(1).printInfoAbbonamento();
		//il pagamento non va a buon fine a causa del metodo di pagamento scelto
		assertFalse(s.scegliAbbonamento(s.getListaUtenti().get(0), s.getListaAbbonamenti().get(1), "ApplePay"));
		//l'utente non possiede alcun abbonamento
		assertTrue(s.getListaUtenti().get(0).getAbbonamentiPosseduti().isEmpty());
	}

}
