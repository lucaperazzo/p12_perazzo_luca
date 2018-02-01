package myclasses;

import java.util.ArrayList;

/**
* Classe Prenotazione
* 
* Classe che rappresenta le prenotazioni effettuate dall'utente. In particolare vengono inseriti i dati riguadanti
* il volo, il numero di passeggeri inclusi nella prenotazione, gli eventuali {@link Extra} presenti, l'identificativo della
* prenotazione e il costo totale comprensivo del costo degli extra
* 
* @version 1.0
* @author Luca Perazzo
*
*/

public class Prenotazione {
	
	private int id_prenotazione;
	private int numPasseggeri;
	private double costoTotale;
	private Volo volo;
	
	private ArrayList<Extra> listaExtra;
	
	/**
	 * Costruttore di Prenotazione: istanzia un nuovo oggetto prenotazione impostando i campi che lo compongono.
	 * 
	 * @param numPasseggeri
	 * 			numero di passeggeri inclusi nella prenotazione
	 * @param volo
	 * 			volo al quale si riferisce la prenotazione		
	 */
	public Prenotazione(int numPasseggeri, Volo volo){
		this.setNumPasseggeri(numPasseggeri);
		this.setVolo(volo);
		this.listaExtra = new ArrayList<Extra>();
		this.setCostoTotale(volo.getPrezzo()*numPasseggeri);
	}
	
	/**
	 * Metodo utilizzato per impostare l'identificativo della prenotazione
	 * 
	 * @param id_prenotazione
	 * 			 identificativo della prenotazione
	 */
	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}

	/**
	 * Metodo utilizzato per la restituzione del volo al quale la corrente prenotazione si riferisce
	 * 
	 * @return volo
	 */
	public Volo getVolo() {
		return volo;
	}

	/**
	 * Metodo utilizzato per l'assegnazione del volo alla prenotazione corrente
	 * 
	 * @param volo 
	 * 			volo selezionato dall'utente in fase di prenotazione
	 */
	public void setVolo(Volo volo) {
		this.volo = volo;
	}
	
	/**
	 * Metodo utilizzato per la restituzione del numero di passeggeri inseriti nella prenotazione
	 * 
	 * @return numPasseggeri
	 */
	public int getNumPasseggeri() {
		return numPasseggeri;
	}

	/**
	 * Metodo utilizzato per impostare il numero di passeggeri inclusi in questa prenotazione
	 * 
	 * @param numPasseggeri 
	 * 			numero di passeggeri per i quali è stata eseguita questa prenotazione
	 */
	public void setNumPasseggeri(int numPasseggeri) {
		this.numPasseggeri = numPasseggeri;
	}
	
	/**
	 * Metodo utilizzato per la restituzione del costo totale della prenotazione
	 * 
	 * @return costoTotale
	 */
	public double getCostoTotale() {
		return costoTotale;
	}

	/**
	 * Metodo utilizzato per impostare il costo totale della prenotazione
	 * 
	 * @param costoTotale 
	 * 					costo totale della prenotazione comprensivo di prezzo del biglietto del volo(moltiplicato 
	 * 					per ogni passeggero) e somma degli extra scelti in fase di prenotazione
	 */
	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	/**
	 * Metodo utilizzato per la restituzione della lista degli extra compresi da questa prenotazione
	 * 
	 * @return listaExtra
	 */
	public ArrayList<Extra> getListExtra() {
		return listaExtra;
	}
	
	/**
	 * Metodo utilizzato per aggiungere un extra alla lista di extra di questa prenotazione
	 * 
	 * @param extra 
	 * 				extra che viene inserito all'interno della listaExtra; può essere di tipo {@link Bagaglio}, 
	 * 				{@link Assicurazione} o {@link Posto}
	 */
	public void addExtra(Extra extra){
		this.getListExtra().add(extra);
	}
	
	/**
	 * Metodo utilizzato per stampare a video tutti i dati della prenotazione corrente. In particolare verranno 
	 * mostrati il numero di prenotazione, il numero del volo scelto, il numero di passeggeri, il costo totale e 
	 * quali extra sono compresi nella prenotazione (se presenti)
	 */
	public void printInfoPrenotazione(){
		System.out.println("Numero Prenotazione: " + id_prenotazione + 
						   "\nVolo Numero: " + volo.getId_volo() +
						   "\nNumero Passeggeri: " + numPasseggeri + 
						   "\nCosto Totale: " + costoTotale);
		if(!listaExtra.isEmpty()){
			System.out.println("EXTRA: ");
			for(int i = 0; i < listaExtra.size(); i++){
				listaExtra.get(i).printInfoExtra();
			}
		}
	}
	
	/**
	 * Metodo utilizzato per modificare una prenotazione; viene aggiornato il prezzo della prenotazione e 
	 * modificato il volo a cui si riferisce
	 * 
	 * @param volo
	 * 			indica il nuovo volo con cui l'utente vorrebbe modificare la prenotazione
	 * @return true se le modifiche vanno a buon fine, false altrimenti
	 */
	public boolean modificaPrenotazione(Volo volo){
		if(volo.getPostiDisponibili()>=this.numPasseggeri){
			this.volo = volo;
			this.costoTotale += volo.getPrezzo()*numPasseggeri - this.getCostoTotale();
			return true;
		}
		return false;
	}

	/**
	 * Metodo utilizzato per la scelta dell' {@link Extra} di tipo {@link Bagaglio}
	 * 
	 * @param tipologia 
	 * 				indica la tipologia del bagaglio che si vuole aggiungere (può essere "a mano" o "in stiva")
	 * @return true se le modifiche vanno a buon fine, false altrimenti
	 */
	public boolean scegliBagaglio(String tipologia){
		Bagaglio b = null;
		if(tipologia.equals("A Mano")){
			b = new Bagaglio(listaExtra.size(), "A Mano", "35cm x 55cm x 25cm", 17.00);
			this.costoTotale += b.getCosto();
			this.addExtra(b);
			return true;
		}else if(tipologia.equals("In Stiva")){
			b = new Bagaglio(listaExtra.size(), "In Stiva", "80cm x 100cm x 40cm", 42.00);
			this.costoTotale += b.getCosto();
			this.addExtra(b);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo utilizzato per la scelta dell' {@link Extra} di tipo {@link Assicurazione}
	 * 
	 * @param tipologia 
	 * 				indica la tipologia di assicurazione che si vuole aggiungere
	 * @return true se le modifiche vanno a buon fine, false altrimenti
	 */
	public boolean scegliAssicurazione(String tipologia){
		Assicurazione a = null;
		if(tipologia.equals("Annullamento")){
			a = new Assicurazione(listaExtra.size(), "Annullamento", 
					"Permette di annullare il proprio viaggio senza alcun costo aggiuntivo", 52.00);
			this.costoTotale += a.getCosto();
			this.addExtra(a);
			return true;
		}else if(tipologia.equals("Infortuni")){
			a = new Assicurazione(listaExtra.size(), "Infortuni", 
					"Copertura assicurativa in caso di infortuni durante il viaggio", 28.00);
			this.costoTotale += a.getCosto();
			this.addExtra(a);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo utilizzato per la scelta dell' {@link Extra} di tipo {@link Posto}
	 * 
	 * @param numPosto 
	 * 				indica il numero del posto che si intende scegliere
	 * @param filaPosto 
	 * 				indica la fila del posto che si intende scegliere
	 * @return true se le modifiche vanno a buon fine, false altrimenti
	 */
	public boolean scegliPosto(int numPosto, char filaPosto){
		Posto p = new Posto(listaExtra.size(), filaPosto, numPosto, 10.00);
		this.costoTotale += p.getCosto();
		this.addExtra(p);
		return true;
	}
	
}
