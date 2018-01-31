package myclasses;

/**
* Classe Recensione
* <p>
* Classe che rappresenta le recensioni che possono essere scritte dagli utenti riguardanti i voli presenti nel sistema.
* 
* @version 1.0
* @author Luca Perazzo
*
*/

public class Recensione {
	
	private int id_recensione;
	private String descrizione;
	private Utente utente;
	private boolean validata;
	private int voto;
	
	/**
	 * Costruttore di Recensione: istanzia un nuovo oggetto recensione impostandone i valori che lo caratterizzano.
	 * Il flag validata è impostato di default a false.
	 * 
	 * @param id_recensione
	 * 			identificativo della recensione
	 * @param descrizione
	 * 			descrizione eseguita da parte dell'utente
	 * @param utente
	 * 			utente che scrive la recensione
	 * @param voto
	 * 			valutazione da parte dell'utente riguardante un determinato volo. Assume valori da 1 a 5
	 */
	public Recensione(int id_recensione, String descrizione, Utente utente, int voto)	{
		this.setId_recensione(id_recensione);
		this.setDescrizione(descrizione);
		this.setUtente(utente);
		this.setValidata(false);
		this.setVoto(voto);
	}

	/**
	 * Metodo utilizzato per la restituzione dell'identificativo della recensione
	 * 
	 * @return id_recensione;
	 */
	public int getId_recensione() {
		return id_recensione;
	}

	/**
	 * Metodo utilizzato per impostare l'identificativo della recensione
	 * 
	 * @param id_recensione
	 * 				 identificativo della recensione
	 */
	public void setId_recensione(int id_recensione) {
		this.id_recensione = id_recensione;
	}

	/**
	 * Metodo utilizzato per la restituzione della descrizione della recensione
	 * 
	 * @return descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Metodo utilizzato per impostare la descrizione di una recensione
	 * 
	 * @param descrizione 
	 * 				descrizione della recensione eseguita dall'utente
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Metodo utlizzato per la restituzione dell'utente che ha scritto la recensione
	 * 
	 * @return utente
	 */
	public Utente getUtente() {
		return utente;
	}

	/**
	 * Metodo utilizzatore per impostare l'utente che ha scritto la recensione 
	 *
	 * @param utente
	 * 				 utente che scrive la recensione
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	/**
	 * Metodo utilizzato per capire se una recensione è stata validato o meno
	 * 
	 * @return validata
	 */
	public boolean isValidata() {
		return validata;
	}

	/**
	 * Metodo utilizzato per impostare il valore del flag validata della recensione
	 * 
	 * @param validata 
	 * 				true o false a seconda se si vuole validare o no la recensione 
	 */
	public void setValidata(boolean validata) {
		this.validata = validata;
	}
	
	/**
	 * Metodo utilizzato per la restituzione del voto assegnato alla recensione da parte dell'utente
	 * 
	 * @return voto
	 */
	public int getVoto() {
		return voto;
	}

	/**
	 * Metodo utilizzato per attribuire un voto alla recensione
	 * 
	 * @param voto 
	 * 				valutazione assegnata dall'utente riguardo alla recensione
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	/**
	 * Metodo utilizzato per stampare a video i dati della recensione in questione. In particolare verranno mostrati
	 * il voto, la descrizione e l'utente che ha eseguito la recensione.
	 */
	public void printInfoRecensione(){
		System.out.println("RECENSIONE\n" +	"\nValutazione: " + voto +
											"\nDescrizione: " + descrizione +
											"\nScritta da: " + utente.getCognome() + " " + utente.getNome());
	}


}
