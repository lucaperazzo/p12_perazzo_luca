package myclasses;

/**
 * Classe Abbonamento
 * <p>
 * Classe che rappresenta gli abbonamenti inseriti all'interno dell'applicazione.
 * 
 * @version 1.0
 * @author Luca Perazzo
 *
 */

public class Abbonamento {
	
	private int id_abbonamento;
	private double prezzo;
	private double miglia;
	private String nomeCompagnia;
		
	/**
	 * Costruttore di Abbonamento: istanzia un oggetto Abbonamento impostandone i parametri principali
	 * 
	 * @param id_abbonamento
	 * 				identificativo dell'abbonamento
	 * @param prezzo
	 * 				costo dell'abbonamento
	 * @param miglia
	 * 				quantità di miglia spendibili attraverso questo abbonamento
	 * @param nomeCompagnia
	 * 				nome compagnia aerea che ha inserito questo abbonamento nel sistema
	 */
	public Abbonamento(int id_abbonamento, double prezzo, double miglia, String nomeCompagnia) {
		this.setId_abbonamento(id_abbonamento);
		this.setPrezzo(prezzo);
		this.setMiglia(miglia);
		this.setNomeCompagnia(nomeCompagnia);
	}

	/**
	 * Metodo utilizzato per la restituzione del prezzo dell'abbonamento
	 * 
	 * @return prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Metodo utilizzato per impostare il prezzo dell'abbonamento
	 * 
	 * @param prezzo
	 * 				costo dell'abbonamento
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Metodo utilizzato per la restituzione dell'identificativo dell'abbonamento
	 * 
	 * @return id_abbonamento
	 */
	public int getId_abbonamento() {
		return id_abbonamento;
	}

	/**
	 * Metodo utilizzato per impostare l'identificativo dell'abbonamento
	 * 
	 * @param id_abbonamento
	 * 				identificativo dell'abbonamento
	 */
	public void setId_abbonamento(int id_abbonamento) {
		this.id_abbonamento = id_abbonamento;
	}

	/**
	 * Metodo utilizzato per la restituzione del numero di miglia che possiede questo abbonamento
	 * 
	 * @return miglia
	 */
	public double getMiglia() {
		return miglia;
	}

	/**
	 * Metodo utilizzato per impostare il numero di miglia per un determinato abbonamento
	 * 
	 * @param miglia
	 * 				miglia comprese dall'abbonamento
	 */
	public void setMiglia(double miglia) {
		this.miglia = miglia;
	}

	/**
	 * Metodo utilizzato per la restituozione del nome della compagnia aerea che ha inserito l'abbonamento
	 * 
	 * @return nomeCompagnia
	 */
	public String getNomeCompagnia() {
		return nomeCompagnia;
	}

	/**
	 * Metodo utilizzato per impostare il nome della compagnia aerea
	 * 
	 * @param nomeCompagnia
	 * 					nome compagnia aerea che ha inserito l'abbonamento nel sistema
	 */
	public void setNomeCompagnia(String nomeCompagnia) {
		this.nomeCompagnia = nomeCompagnia;
	}

	/**
	 * Metodo utilizzato per stampare a video le informazioni riguardanti l'abbonamento in questione. In particolare
	 * verranno mostrati le miglia percorribili, il prezzo e la compagnia aerea
	 */
	public void printInfoAbbonamento(){
			System.out.println("Miglia Percorribili: " + miglia +
							   "\n Prezzo: " + prezzo + 
							   "\n Compagnia Aerea: " + nomeCompagnia);
	}
}
