package myclasses;

import java.util.Calendar;

/**
 * Classe Pagamento
 * <p>
 * Classe che rappresenta il Pagamento. Comprende il metodo che simulerà l'operazione di pagamento come specificato
 * nella sezione 2 dell'SDD.
 * 
 * @version 1.0
 * @author Luca Perazzo
 *
 */
public class Pagamento {
	
	private int id_pagamento;
	private String tipologia;
	private double costoTotale;
	private Calendar data;
	
	/**
	 * Costruttore di default della classe Pagamento
	 */
	public Pagamento(){
		this.data = Calendar.getInstance();
	}
	
	/**
	 * Costruttore di Pagamento: istanzia un nuovo oggetto di tipo pagamento impostandone i parametri che lo 
	 * 							 caratterizzano
	 * @param id_pagamento
	 * 				identificativo del pagamento
	 * @param tipologia
	 * 				tipologia di pagamento
	 * @param costoTotale
	 * 				costo totale che riferito al pagamento in questione
	 */
	public Pagamento(int id_pagamento, String tipologia, double costoTotale)	{
		this.setId_pagamento(id_pagamento);
		this.setTipologia(tipologia);
		this.setCostoTotale(costoTotale);
		this.data = Calendar.getInstance();
	}

	/**
	 * Metodo utilizzato per la restituzione dell'identificativo del pagamento
	 * 
	 * @return id_pagamento
	 */
	public int getId_pagamento() {
		return id_pagamento;
	}

	/**
	 * Metodo utilizzato per impostare l'identificativo del pagamento
	 * 
	 * @param id_pagamento
	 * 				identificativo del pagamento
	 */
	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	/**
	 * Metodo utilizzato per la restituzione della tipologia di pagamento
	 * 
	 * @return tipologia
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * Metodo utilizzato per impostare la tipologia del pagamento
	 * 
	 * @param tipologia
	 * 				tipologia di pagamento scelta dall'utente
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * Metodo utilizzato per la restituzione del costo totale del pagamento in questione
	 * 
	 * @return costoTotale
	 */
	public double getCostoTotale() {
		return costoTotale;
	}

	/**
	 * Metodo utilizzato per impostare il costo totale del pagamento
	 * 
	 * @param costoTotale
	 * 				costo totale del pagamento
	 */
	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	/**
	 * Metodo utilizzato dal sistema per simulare un pagamento
	 * 
	 * @param utente
	 * 				utente che esegue il pagamento
	 * @param prenotazione
	 * 				prenotazione che l'utente intende acquistare
	 * @param tipologia
	 * 				tipologia di pagamento scelta dall'utente
	 * @return true se il pagamento va a buon fine, false altrimenti
	 */
	public static boolean paga(Utente utente, Prenotazione prenotazione, String tipologia){
		if(!tipologia.equals("PayPal") && !tipologia.equals("Carta")){
			return false;
		}
		Pagamento p = new Pagamento(utente.getPagamentiEffettuati().size(), tipologia, 
									prenotazione.getCostoTotale());
		utente.getPagamentiEffettuati().add(p);
		return true;
	}
	
	/**
	 * Metodo utilizzato dal sistema per simulare un pagamento
	 * 
	 * @param utente
	 * 				utente che esegue il pagamento
	 * @param abbonamento
	 * 				abbonamento che l'utente intende acquistare
	 * @param tipologia
	 * 				tipologia di pagamento scelta dall'utente
	 * @return true se il pagamento va a buon fine, false altrimenti
	 */
	public static boolean paga(Utente utente, Abbonamento abbonamento, String tipologia){
		if(!tipologia.equals("PayPal") && !tipologia.equals("Carta")){
			return false;
		}
		Pagamento p = new Pagamento(utente.getPagamentiEffettuati().size(), tipologia, 
									abbonamento.getPrezzo());
		utente.getPagamentiEffettuati().add(p);
		return true;
	}
	
	/**
	 * Metodo utilizzato per stampare a video i dati del pagamento in quesitone. In particolare verranno mostrati 
	 * l'identificativo del pagamento, la modalità scelta, l'importo pagato e la data in cui è stato eseguito il 
	 * pagamento
	 */
	public void printInfoPagamento(){
		System.out.println("Identificativo Pagamento: " + id_pagamento + 
				   "\nModalità Pagamento: " + tipologia  +
				   "\nImporto pagato: " + costoTotale +
				   "\nData Pagamento: " + data.getTime());
	}
}
