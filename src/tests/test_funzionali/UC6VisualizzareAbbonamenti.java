package test_funzionali;

import org.junit.Before;
import org.junit.Test;

import myclasses.Abbonamento;
import myclasses.Utente;
import system.Sistema;

public class UC6VisualizzareAbbonamenti {
	
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
		s.addUtente(u1);
		s.login(s.getListaUtenti().get(0).getUsername(), s.getListaUtenti().get(0).getPassword());
		
		s.addAbbonamento(a1);
		s.addAbbonamento(a2);
		s.addAbbonamento(a3);
	}

	//Scenario principale: l'utente visualizza tutti gli abbonamenti presenti nel sistema
	@Test
	public void UC6test1() {
		s.visualizzaAbbonamenti();
	}
	
	//Scenario alternativo 2a. : non ci sono abbonamenti inseriti nel sistema
	@Test
	public void UC6test2() {
		//rimuovo gli abbonamenti inseriti nel sistema
		s.getListaAbbonamenti().remove(0);
		s.getListaAbbonamenti().remove(0);
		s.getListaAbbonamenti().remove(0);
		//non ci sono abbonamenti nel sistema, viene mostrata una schermata vuota
		s.visualizzaAbbonamenti();
	}

}
