package myclasses;

/**
 * Classe Bagaglio
 * <p>
 * Questa classe è un tipo di {@link Extra} che rappresenta uno specifico bagaglio tra quelli disponibili
 * 
 * @version 1.0
 * @see Extra
 * @author Luca Perazzo
 *
 */
public class Bagaglio extends Extra {
	
	private String tipologia;
	private String grandezza;
	private double costo;

	/**
	 * Costruttore di Bagalio: istanzia un nuovo oggetto di tipo Bagaglio impostandone i parametri che lo caratterizzano
	 * 
	 * @param id_extra
	 * 				identificativo dell'extra
	 * @param tipologia
	 * 				tipologia di bagaglio che si intende scegliere
	 * @param grandezza
	 * 				dato riguardante la grandezza del bagaglio legato alla tipologia scelta
	 * @param costo
	 * 				costo dell'extra in questione
	 */
	public Bagaglio(int id_extra, String tipologia, String grandezza, double costo) {
		super(id_extra);
		// TODO Auto-generated constructor stub
		
		this.tipologia = tipologia;
		this.grandezza = grandezza;
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
	 * 			costo del bagaglio scelto
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	/**
	 * Metodo che permette di stampare tutte le informazioni dell'extra in questione
	 */
	@Override
	public void printInfoExtra(){
		System.out.println("Bagaglio: " + tipologia + ", " + grandezza);
	}
}
