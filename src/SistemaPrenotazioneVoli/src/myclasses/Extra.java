package myclasses;

/**
 * Classe Extra
 * <p>
 * Classe che rappresenta gli Extra che possono essere aggiunti alla {@link Prenotazione}
 * 
 * @version 1.0
 * @author Luca Perazzo
 *
 */

public class Extra {
	private int id_extra;
	
	/**
	 * Costruttore di Extra: istanzia un nuovo oggetto di tipo Extra impostandone l'identificativo
	 * @param id_extra
	 * 				identificativo dell'extra
	 */
	public Extra(int id_extra)	{
		this.setId_extra(id_extra);
	}

	/**
	 * Metodo utilizzato per la restituzione dell'identificativo dell'extra
	 * 
	 * @return id_extra
	 */
	public int getId_extra() {
		return id_extra;
	}

	/**
	 * Metodo utilizzato per impostare l'identificativo dell'extra
	 * 
	 * @param id_extra
	 * 				identificativo dell'extra
	 */
	public void setId_extra(int id_extra) {
		this.id_extra = id_extra;
	}

	/**
	 * Metodo utilizzato per stampare le informazioni relative all'extra
	 */
	public void printInfoExtra() {
		// TODO Auto-generated method stub
	}
}
