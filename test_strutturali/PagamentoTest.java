package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Abbonamento;
import myclasses.Pagamento;
import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;

public class PagamentoTest {
	
	Utente u1;
	Prenotazione p1;
	Pagamento pagamento;
	Abbonamento a1;
	Volo v1;
	
	@Before
	public void setUp() throws Exception {
		pagamento = new Pagamento();
		pagamento = new Pagamento(250, "PayPal", 118.00);
		u1 = new Utente(1, "Mario", "Rossi", "mariorossi", "psswrd", "mariorossi@gmail.com");
		v1 = new Volo(642, "Roma", "Madrid", 40, 2.30, "11.30", "14.00", 59.00, 500.00, "RyanAir");
		p1 = new Prenotazione(2, v1);
		a1 = new Abbonamento(101, 300.00, 1500.00, "RyanAir");	
	}

	@Test
	public void testCostruttore() {
		assertNotNull(pagamento);
		assertEquals(250, pagamento.getId_pagamento());
		assertEquals("PayPal", pagamento.getTipologia());
		assertEquals(118.00, pagamento.getCostoTotale(), 00.00);
	}
	
	@Test
	public void testInfoPagamento() {
		pagamento.printInfoPagamento();
	}
	
	//effettuo il pagamento sia per una prenotazione che per un abbonamento, con entrambe le tipologie
	//permesse e con una non permessa
	@Test
	public void testPaga() {	
		assertTrue(Pagamento.paga(u1, p1, "PayPal"));
		assertTrue(Pagamento.paga(u1, a1, "Carta"));
		assertTrue(Pagamento.paga(u1, p1, "Carta"));
		assertTrue(Pagamento.paga(u1, a1, "PayPal"));
		assertFalse(Pagamento.paga(u1, p1, "ApplePay"));
		assertFalse(Pagamento.paga(u1, a1, "ApplePay"));
	}

}
