package test_funzionali;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;
import system.Sistema;

public class UC5ModificareUnaPrenotazione {

	Volo v1;
	Prenotazione p;
	Utente u1;
	Sistema s;

	
	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		p = new Prenotazione(3, v1);
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		u1.getListaPrenotazioni().add(p);
		
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
	}

	//Scenario principale: l'utente modifica la prenotazione con successo
	@Test
	public void UC5test1() {
		Volo v2 = new Volo(644, "Milano", "Londra", 25, 2.00, "12.00", "14.00", 41.00, 400.00, "EasyJet");
		//vengono mostrati i dettagli della prenotazione
		u1.getListaPrenotazioni().get(0).printInfoPrenotazione();
		//la modifica della prenotazione va a buon fine
		assertTrue(u1.getListaPrenotazioni().get(0).modificaPrenotazione(v2));
		//la prenotazione adesso riguarda il nuovo volo v2 
		assertEquals(v2, u1.getListaPrenotazioni().get(0).getVolo());
		u1.getListaPrenotazioni().get(0).printInfoPrenotazione();
	}

	//Scenario alternativo 2a. : l'utente non ha effettuato alcuna prenotazione
	@Test
	public void UC5test2() {
		//rimuovo la prenotazione da quelle possedute
		u1.getListaPrenotazioni().remove(0);
		//l'utente non possiede prenotazioni da poter modificare
		assertTrue(u1.getListaPrenotazioni().isEmpty());
	}
	
	//Scenario alternativo 5a. : l'utente decide di  annullare l'operazione di modifica
		@Test
		public void UC5test3() {
			u1.getListaPrenotazioni().get(0).printInfoPrenotazione();
			//l'utente annulla e quindi nessun dato viene modificato
			assertEquals(v1, u1.getListaPrenotazioni().get(0).getVolo());
		}
	
	//Scenario alternativo 5b. : l'utente decide di  eliminare la prenotazione
	@Test
	public void UC5test4() {
		u1.getListaPrenotazioni().get(0).printInfoPrenotazione();
		//rimuovo la prenotazione 
		assertTrue(u1.destroyPrenotazione(u1.getListaPrenotazioni().get(0)));
		//non ho più nessuna prenotazione posseduta
		assertTrue(u1.getListaPrenotazioni().isEmpty());
	}
	
	//Lo scenario alternativo 5b. - 3a. coincide con le stesse operazioni eseguite in UC5test3(),
	//in quanto non vengono tenute in conto le dinamiche dovute all'interfaccia grafica.
	
	//Scenario alternativo 7a. : il sistema non convalida le modifiche
	@Test
	public void UC5test5() {
		Volo v2 = new Volo(644, "Milano", "Londra", 1, 2.00, "12.00", "14.00", 41.00, 400.00, "EasyJet");
		//vengono mostrati i dettagli della prenotazione
		u1.getListaPrenotazioni().get(0).printInfoPrenotazione();
		//non ci sono abbastanza posti disponibili quindi il sistema rifiuta la modifica
		assertFalse(u1.getListaPrenotazioni().get(0).modificaPrenotazione(v2));
		//la prenotazione riguarda ancora il volo inserito in precedenza
		assertEquals(v1, u1.getListaPrenotazioni().get(0).getVolo());
		u1.getListaPrenotazioni().get(0).printInfoPrenotazione();
	}
	
	
}
