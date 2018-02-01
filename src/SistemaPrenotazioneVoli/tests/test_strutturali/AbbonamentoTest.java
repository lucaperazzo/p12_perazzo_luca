package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Abbonamento;

public class AbbonamentoTest {
	
	Abbonamento a1;

	@Before
	public void setUp() throws Exception {
		a1 = new Abbonamento(101, 300.00, 1500.00, "RyanAir");
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(a1);
		assertEquals(101, a1.getId_abbonamento());
		assertEquals(300.00, a1.getPrezzo(), 0.00);
		assertEquals(1500.00, a1.getMiglia(), 0.00);
		assertEquals("RyanAir", a1.getNomeCompagnia());
	}
	
	@Test
	public void testInfoAbbonamento() {
		a1.printInfoAbbonamento();
	}

}
