package test_funzionali;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import myclasses.Volo;
import system.Sistema;

public class UC2RicercaVolo {

	Sistema s;
	Volo v1, v2;
	Calendar data;
	
	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		data = Calendar.getInstance();
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		v2 = new Volo(645, "Roma", "Madrid", 25, 2.20, "17.30", "19.50", 71.00, 500.00, "EasyJet");
		
		s.addVolo(v1, 10);
		s.addVolo(v2, 15);
	}

	//Scenario principale: ricerca volo soddisfatta
	@Test
	public void UC2test1() {
		data.set(2018, 1, 4);
		s.ricercaVolo("Roma", "Madrid", data, 4);
	}
	
	//Scenario alternativo 5a. : nessun volo soddisfa la ricerca
	@Test
	public void UC2test2() {
		data.set(2018, 2, 4);
		s.ricercaVolo("Roma", "Madrid", data, 4);
	}

}
