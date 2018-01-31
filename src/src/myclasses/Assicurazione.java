package myclasses;

/**
 * Classe Assicurazione
 * <p>
 * Questa classe è un tipo di {@link Extra} che rappresenta un tipo di assicurazione tra quelle disponibili
 * 
 * @version 1.0
 * @see Extra
 * @author Luca Perazzo
 *
 */
public class Assicurazione extends Extra{
	
	private String tipologia;
	private String descrizione;
	private double costo;

	/**
	 * Costruttore di Assicurazione: istanzia un oggetto di tipo Assicurazione impostandone tutti i paramtri che lo 
	 * 								 caratterizzano
	 * 
	 * @param id_extra
	 * 				identificativo dell'extra
	 * @param tipologia
	 * 				tipologia di assicurazione scelta dall'utente
	 * @param descrizione
	 * 				descrizione dell'assicurazione scelta
	 * @param costo
	 * 				costo dell'extra in questione
	 */
	public Assicurazione(int id_extra, String tipologia, String descrizione, double costo) {
		super(id_extra);
		// TODO Auto-generated constructor stub
		
		this.tipologia = tipologia;
		this.descrizione = descrizione;
		this.setCosto(costo);
	}

	/**
	 * Metodo che permette la restituzione del costo dell'extra in questione
	 * 
	 * @return costo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * Metodo che permette di impostare il costo dell'extra
	 * 
	 * @param costo
	 * 			costo dell'assicurazione scelta
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	/**
	 * Metodo che permette di stampare tutte le informazioni dell'extra in questione
	 */
	@Override
	public void printInfoExtra(){
		System.out.println("Assicurazione: " + tipologia + ", " + descrizione);
	}

}
