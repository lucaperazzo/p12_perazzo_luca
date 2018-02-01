package myclasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Classe Volo
 * <p>
 * Classe che rappresenta i voli inseriti nel sistema, caratterizzati dal luogo di partenza e di arrivo, dall'orario 
 * di partenza e arrivo e della relativa data del viaggio, dal nome della compagnia aerea, dai posti diponibili 
 * sull'aereo, dal prezzo del biglietto e dalle miglia percorse dal volo. Ogni volo ha una lista di recensioni che 
 * può essere riempita dai vari utenti del sistema.
 * 
 * @version 1.0
 * @author Luca Perazzo
 *
 */

public class Volo implements Cloneable{
	
	private int id_volo;
	private String partenza;
	private String arrivo;
	private String orarioPartenza;
	private String orarioArrivo;
	private int postiDisponibili;
	private double durata;
	private double prezzo;
	private double miglia;
	private String nomeCompagnia;
	private Calendar data;
	
	private ArrayList<Recensione> listaRecensioni;
	
	
	/**
	 * Override del metodo clone() della classe Object, utilizzato per clonare un oggetto di questa classe
	 */
	 @Override
	    protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
	 
	 /**
	  * Metodo utilizzato per accedere alla funzione clone() da un altro package
	  * 
	  * @throws Exception in caso in cui non riesca a ritornare il metodo clone()
	  * 
	  * @return clone(), oggetto clonato
	  */
	 public Object getClone() throws Exception{
		 return this.clone();
	 }
	 
	/**
	 * Costruttore della classe volo: istanzia un nuovo oggetto di tipo Volo impostandone i parametri principali 
	 * della classe.
	 * 
	 * @param id_volo
	 * 			identificativo del volo
	 * @param partenza
	 * 			luogo della partenza
	 * @param arrivo
	 * 			luogo di arrivo
	 * @param postiDisponibili
	 * 			posti disponibli sull'aereo
	 * @param durata
	 * 			durata del volo
	 * @param orarioPartenza
	 * 			orario di partenza del volo
	 * @param orarioArrivo
	 * 			orario di arrivo del volo
	 * @param prezzo
	 * 			prezzo del biglietto per un determinato volo
	 * @param miglia
	 * 			numero di miglia percorse dal volo
	 * @param nomeCompagnia
	 * 			nome della compagnia aerea che gestisce il volo
	 */
	public Volo (int id_volo, String partenza, String arrivo, int postiDisponibili, double durata,
				String orarioPartenza, String orarioArrivo, double prezzo, double miglia, String nomeCompagnia){
		this.setId_volo(id_volo);
		this.setPartenza(partenza);
		this.setArrivo(arrivo);
		this.setOrarioPartenza(orarioPartenza);
		this.setOrarioArrivo(orarioArrivo);
		this.setPostiDisponibili(postiDisponibili);
		this.setDurata(durata);
		this.setPrezzo(prezzo);
		this.setMiglia(miglia);
		this.setNomeCompagnia(nomeCompagnia);
		this.listaRecensioni = new ArrayList<Recensione>();
	}

	/**
	 * Metodo utilizzato per la restituzione del valore del campo id_volo
	 * 
	 * @return id_volo
	 */
	public int getId_volo() {
		return id_volo;
	}

	/**
	 * Metodo utilizzato per impostare l'identificativo del volo
	 * 
	 * @param id_volo 
	 * 				identificativo del volo
	 */
	public void setId_volo(int id_volo) {
		this.id_volo = id_volo;
	}

	/**
	 * Metodo utilizzato per la restituzione del valore del campo partenza del volo
	 * 
	 * @return partenza
	 */
	public String getPartenza() {
		return partenza;
	}

	/**
	 * Metodo utilizzato per impostare il luogo di partenza del volo
	 * 
	 * @param partenza
	 * 			 luogo di partenza del volo
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	
	/**
	 * Metodo utilizzato per la restituzione del valore del campo arrivo del volo
	 * 
	 * @return arrivo
	 */
	public String getArrivo() {
		return arrivo;
	}

	/**
	 * Metodo utilizzato per impostare il luogo di arrivo del volo
	 * 
	 * @param arrivo 
	 * 			luogo di arrivo del volo
	 */
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}

	/**
	 * Metodo utilizzato per la restituzione della durata del volo
	 * 
	 * @return durata
	 */
	public double getDurata() {
		return durata;
	}

	/**
	 * Metodo utilizzato per impostare la durata del volo
	 * @param durata
	 * 			 durata del volo
	 */
	public void setDurata(double durata) {
		this.durata = durata;
	}

	/**
	 * Metodo utilizzato per la restituzione del numero di miglia percorse dal volo
	 * 
	 * @return miglia
	 */
	public double getMiglia() {
		return miglia;
	}

	/**
	 * Metodo utilizzato per impostare il numero di miglia percorse dal volo
	 * 
	 * @param miglia 
	 * 			miglia percorse dal volo
	 */
	public void setMiglia(double miglia) {
		this.miglia = miglia;
	}

	/**
	 * Metodo utilizzato per la restituzione del prezzo del biglietto
	 * 
	 * @return prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Metodo utilizzato per impostare il prezzo del biglietto
	 * 
	 * @param prezzo 
	 * 			prezzo del biglietto
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Metodo utilizzato per la restituzione del numero di posti attualmente disponibili sull'aereo
	 * 
	 * @return postiDisponibili
	 */
	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	/**
	 * Metodo utilizzato per impostare il numero di posti disponibili su un aereo
	 * 
	 * @param postiDisponibili 
	 * 				posti attualmente disponibili su un determinato aereo
	 */
	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	/**
	 * Metodo utilizzato per la restituzione dell'orario di partenza del volo
	 * 
	 * @return orarioPartenza
	 */
	public String getOrarioPartenza() {
		return orarioPartenza;
	}

	/**
	 * Metodo utilizzato per impostare l'orario di partenza di un volo
	 * 
	 * @param orarioPartenza
	 * 				 orario di partenza di un determinato volo
	 */
	public void setOrarioPartenza(String orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}

	/**
	 * Metodo utilizzato per la restituzione dell'orario di arrivo del volo
	 * 
	 * @return orarioArrivo
	 */	public String getOrarioArrivo() {
		return orarioArrivo;
	}
	
	 /**
	  * Metodo utilizzato per impostare l'orario di arrivo di un volo
	  * 
	  * @param orarioArrivo 
	  * 			orario di arrivo di un determinato volo    
      */
	public void setOrarioArrivo(String orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}
	
	/**
	 * Metodo utilizzato per la restituzione del nome della compagnia aerea che possiede il volo in questione
	 * 
	 * @return nomeCompagnia
	 */
	public String getNomeCompagnia() {
		return nomeCompagnia;
	}

	/**
	 * Metodo utilizzato per impostare il nome della compagnia per un determinato volo
	 * 
	 * @param nomeCompagnia
	 * 				 nome della compagnia aerea che gestisce il volo in questione
	 */
	public void setNomeCompagnia(String nomeCompagnia) {
		this.nomeCompagnia = nomeCompagnia;
	}
	
	/**
	 * Metodo utilizzato per la restituzione della data del volo nel formato "dd/mm/yyyy"
	 * 
	 * @return dataFormattata
	 */
	public String getDataFormattata() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormattata = formatter.format(getData().getTime());
		return dataFormattata;
	}
	
	/**
	 * Metodo utilizzato per la restituzione della data del volo 
	 * 
	 * @return data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * Metodo utilizzato per impostare la data secondo il formato anno-mese-giorno
	 * 
	 * @param anno
	 * 			anno che si sta impostando
	 * @param mese
	 * 			mese che si sta impostando 
	 * @param giorno
	 * 			giorno che si sta impostando
	 */		
	public void setData(int anno, int mese, int giorno) {
		data = Calendar.getInstance();
		this.data.set(anno, mese, giorno);
	}
	
	/**
	 * Metodo utilizzato per la restituzione della lista delle recensioni che riguardano il volo in questione
	 * 
	 * @return recensioni
	 */
	public ArrayList<Recensione> getListaRecensioni() {
		return listaRecensioni;
	}

	/**
	 * Metodo che permette di stampare a video tutti i dati relativi ad un determinato volo. In particolare verranno
	 * mostrati il numero del volo, la partenza e l'arrivo, la data, la durata, la compagnia di riferimento, il 
	 * prezzo del biglietto e il numero di miglia.
	 */
	public void printInfoVolo() {
		System.out.println("Volo numero: " + this.id_volo);
		System.out.println("Partenza: " + this.partenza + " Ore " + this.orarioPartenza);
		System.out.println("Arrivo: " + this.arrivo  + " Ore " + this.orarioArrivo);
		System.out.println("Il: " + this.getDataFormattata());
		System.out.println("Durata: " + this.durata + " ore");
		System.out.println("Compagnia: " + this.nomeCompagnia);
		System.out.println("Prezzo: " + this.prezzo + " €");
		System.out.println("Miglia: " + this.miglia);
	}
	/**
	 * Metodo che permette di stampare a video le informazioni relative a tutte le recensioni di un determinato volo,
	 */
	public void visualizzaRecensioni(){
		if(!this.getListaRecensioni().isEmpty()){
			System.out.println("Volo numero: " + this.id_volo);
			for(int i = 0; i < this.getListaRecensioni().size(); i++){
					this.getListaRecensioni().get(i).printInfoRecensione();
			}
		}else{
			System.out.println("Nessuna recensione presente per questo volo.");
		}
	}
	
	/**
	 * Metodo che permette di inserire una nuova recensione (ancora da validare) all'interno della lista delle 
	 * recensioni del volo in questione.
	 * 
	 * @param utente
	 * 			utente che ha scritto la recensione
	 * @param voto
	 * 			valore compreso tra 1 e 5 che determina la valutazione complessiva del volo
	 * @param descrizione
	 * 			descrizione eseguita dall'utente che evidenzia il suo parere riguardo al volo che ha effettuato
	 * @return true se i dati inseriti sono conformi (voto compreso tra 1 e 5, descrizione non nulla), false altrimenti
	 */
	public boolean addRecensione(Utente utente, int voto, String descrizione){
		if(utente==null || descrizione.equals("") || voto>5 || voto<=0){
			return false;
		}else{
			Recensione r = new Recensione(this.listaRecensioni.size(), descrizione, utente, voto);
			this.listaRecensioni.add(r);
			return true;
		}
	}
}
