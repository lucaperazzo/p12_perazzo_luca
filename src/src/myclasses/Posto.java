package myclasses;

/**
 * Classe Posto
 * <p>
 * Questa classe è un tipo di {@link Extra} che rappresenta un posto specifico all'interno dell'aereo
 * 
 * @version 1.0
 * @see Extra
 * @author Luca Perazzo
 *
 */
public class Posto extends Extra{
	
	private char fila;
	private int numero;
	private double costo;
	
	
	/**
	 * Costruttore di Posto: istanzia un nuovo oggetto di tipo Posto impostandone i parametri che lo caratterizzano
	 * 
	 * @param id_extra
	 * 			identificativo dell'extra
	 * @param fila
	 * 			indica la fila del posto all'interno dell'aereo
	 * @param numero
	 * 			indica il numero del posto all'interno dell'aereo
	 * @param costo
	 * 			indica il costo di questo specifico extra
	 */
	public Posto(int id_extra, char fila, int numero, double costo) {
		super(id_extra);
		// TODO Auto-generated constructor stub
		this.fila = fila;
		this.numero = numero;
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
	 * 			costo del posto
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	/**
	 * Metodo che permette di stampare tutte le informazioni dell'extra in questione
	 */
	@Override
	public void printInfoExtra(){
		System.out.println("Posto numero " + numero + ", fila " + fila);
	}

}
