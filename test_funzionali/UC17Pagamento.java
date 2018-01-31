package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;
import system.Sistema;

public class UC17Pagamento {

	Sistema s;
	Utente u1;
	Volo v1;
	Prenotazione p;
	
	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		p = new Prenotazione(3, v1);
		
		s.addVolo(v1, 10);
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: l'utente esegue il pagamento con successo tramite carta di credito
	@Test
	public void UC17test1() {
		System.out.println(p.getCostoTotale());
		//il pagamento va a buon fine
		assertTrue(s.prenotaVolo(s.getListaUtenti().get(0), p, "Carta"));
		//l'utente si ritrova il pagamento effettuati nel proprio profilo
		assertFalse(s.getListaUtenti().get(0).getPagamentiEffettuati().isEmpty());
	}
	
	//Scenario alternativo 2a. : l'utente decide di non proseguire con il pagamento
	@Test
	public void UC17test2() {
		System.out.println(p.getCostoTotale());
		//l'utente annulla l'operazione di pagamento, il pagamento non viene registrato
		assertTrue(s.getListaUtenti().get(0).getPagamentiEffettuati().isEmpty());
	}
	
	//Scenario alternativo 4a. : l'utente esegue il pagamento con successo tramite PayPal
	@Test
	public void UC17test3() {
		System.out.println(p.getCostoTotale());
		//il pagamento va a buon fine
		assertTrue(s.prenotaVolo(s.getListaUtenti().get(0), p, "PayPal"));
		//l'utente si ritrova il pagamento effettuati nel proprio profilo
		assertFalse(s.getListaUtenti().get(0).getPagamentiEffettuati().isEmpty());
	}
	
	//Scenario alternativo 6a. : l'utente non riesce ad eseguire il pagamento
	@Test
	public void UC17test4() {
		System.out.println(p.getCostoTotale());
		//il pagamento non va a buon fine
		assertFalse(s.prenotaVolo(s.getListaUtenti().get(0), p, "ApplePay"));
		//l'utente non ha alcun pagamento tra quelli effettuati
		assertTrue(s.getListaUtenti().get(0).getPagamentiEffettuati().isEmpty());
	}

}
