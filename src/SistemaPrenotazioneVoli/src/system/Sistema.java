package system;

import java.util.ArrayList;
import java.util.Calendar;

import myclasses.Abbonamento;
import myclasses.Pagamento;
import myclasses.Prenotazione;
import myclasses.Utente;
import myclasses.Volo;

/**
 * Classe Sistema
 * <p>
 * Classe che rappresenta il Sistema. Tiene traccia degli utenti, degli abbonamenti e dei voli presenti nel sistema.
 * 
 * @version 1.0
 * @author Luca Perazzo
 *
 */

public class Sistema {
	
	//vettore con utenti presenti nel sistema
	private  ArrayList<Utente> listaUtenti;
	//vettore con voli presenti nel sistema
	private  ArrayList<Volo> listaVoli;
	//vettore con abbonamenti presenti nel sistema
	private  ArrayList<Abbonamento> listaAbbonamenti;
	
	/**
	 * Costruttore di sistema: inizializza le liste rispettivamente di utenti, voli e abbonamenti
	 */
	public Sistema(){
		this.setListaUtenti(new ArrayList<Utente>());
		this.setListaVoli(new ArrayList<Volo>());
		this.setListaAbbonamenti(new ArrayList<Abbonamento>());
	}
	
	/**
	 * Metodo utilizzato per la restituzione della lista degli utenti presenti nel sistema
	 * 
	 * @return listaUtenti
	 */
	public ArrayList<Utente> getListaUtenti() {
		return listaUtenti;
	}

	/**
	 * Metodo utilizzato per impostare l'ArrayList contenente gli utenti del sistema
	 * 
	 * @param listaUtenti
	 * 			lista degli utenti presenti nel sistema
	 */
	public void setListaUtenti(ArrayList<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	/**
	 * Metodo utilizzato per la restituzione della lista dei voli presenti nel sistema
	 * 
	 * @return listaVoli
	 */
	public ArrayList<Volo> getListaVoli() {
		return listaVoli;
	}

	 /** Metodo utilizzato per impostare l'ArrayList contenente i voli del sistema
	 * 
	 * @param listaVoli
	 * 			lista dei voli presenti nel sistema
	 */
	public void setListaVoli(ArrayList<Volo> listaVoli) {
		this.listaVoli = listaVoli;
	}

	/**
	 * Metodo utilizzato per la restituzione della lista degli abbonamenti presenti nel sistema
	 * 
	 * @return listaAbbonamenti
	 */
	public ArrayList<Abbonamento> getListaAbbonamenti() {
		return listaAbbonamenti;
	}

	/**
	 * Metodo utilizzato per impostare l'ArrayList contenente gli abbonamenti del sistema
	 * 
	 * @param listaAbbonamenti
	 * 			lista degli abbonamenti presenti nel sistema
	 */
	public void setListaAbbonamenti(ArrayList<Abbonamento> listaAbbonamenti) {
		this.listaAbbonamenti = listaAbbonamenti;
	}

	/**
	 * Metodo utilizzato per far effettuare ad un utente il login. In caso di riuscita imposta il flag autenticato a 
	 * true.
	 * 
	 * @param username
	 * 			username dell'utente
	 * @param password
	 * 			password dell'utente
	 * @return true se username e password sono corrette, false altrimenti
	 */
	public boolean login(String username, String password){
		if(!listaUtenti.isEmpty()){
			for(int i = 0; i < listaUtenti.size(); i++){
				if(username.equals(listaUtenti.get(i).getUsername()) && password.equals(listaUtenti.get(i).getPassword())
					&& !listaUtenti.get(i).isAutenticato()){
					listaUtenti.get(i).setAutenticato(true);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Metodo utilizzato per far effettuare ad un utente il logout. In caso di riuscita imposta il flag autenticato
	 * a false
	 * 
	 * @param utente
	 * 			utente che intende eseguire il logout
	 * @return	true se il logout va a buon fine, false altrimenti
	 */
	public boolean logout(Utente utente){
		if(!listaUtenti.isEmpty()){
			for(int i = 0; i < listaUtenti.size(); i++){
				if(utente.getId_utente() == (listaUtenti.get(i).getId_utente()) && listaUtenti.get(i).isAutenticato()){
					listaUtenti.get(i).setAutenticato(false);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Metodo utilizzato per la ricerca di un volo. Stampa a video una lista di voli congruente con i parametri di 
	 * ricerca inseriti
	 * 
	 * @param partenza
	 * 			città di partenza
	 * @param arrivo
	 * 			città di arrivo
	 * @param data
	 * 			data inserita dall'utente
	 * @param numPasseggeri
	 * 			numero dei passeggeri per cui si sta ricercando un volo disponibile
	 */
	public void ricercaVolo(String partenza, String arrivo, Calendar data, int numPasseggeri){
		System.out.println("Soluzioni trovate:");
		for(int i = 0; i < listaVoli.size(); i++){
			if(listaVoli.get(i).getPartenza().equals(partenza) && listaVoli.get(i).getArrivo().equals(arrivo)
				&& listaVoli.get(i).getPostiDisponibili()>=numPasseggeri && 
				data.get(Calendar.DAY_OF_YEAR) == ((listaVoli.get(i).getData()).get(Calendar.DAY_OF_YEAR))){
				listaVoli.get(i).printInfoVolo();
				System.out.println();
			}
		}
	}
	
	/**
	 * Metodo utilizzato per prenotare un volo. Crea un oggetto {@link Prenotazione} e lo riempie con i dati inseriti
	 * dall'utente, in seguito esegue il metodo paga di {@link Pagamento}
	 * 
	 * @param utente
	 * 				utente che intende prenotare il volo
	 * @param prenotazione
	 * 				prenotazione che si vuole prenotare
	 * @param modalitàPagamento
	 * 				modalità di pagamento con cui si intende pagare
	 * @return true se il pagamento (e quindi la prenotazione) va a buon fine, false altrimenti
	 */
	public boolean prenotaVolo(Utente utente, Prenotazione prenotazione, String modalitàPagamento){
		prenotazione.setId_prenotazione(utente.getListaPrenotazioni().size());
		if(!Pagamento.paga(utente, prenotazione, modalitàPagamento)){
			prenotazione = null;
			return false;	
		}else{
			prenotazione.getVolo().setPostiDisponibili(prenotazione.getVolo().getPostiDisponibili() -
														prenotazione.getNumPasseggeri());
			utente.getListaPrenotazioni().add(prenotazione);
			utente.addMiglia(prenotazione.getVolo().getMiglia());
			return true;
		}
	}

	/**
	 * Metodo utilizzato per stampare a video tutti gli abbonamenti presenti nel sistema
	 */
	public void visualizzaAbbonamenti(){
		if(!listaAbbonamenti.isEmpty()){
			for(int i = 0; i < listaAbbonamenti.size(); i++){
				listaAbbonamenti.get(i).printInfoAbbonamento();
			}
		}
	}

	/**
	 * Metodo utilizzato per acquistare un abbonamento. Viene eseguito il metodo paga di {@link Pagamento}
	 *  
	 * @param utente
	 * 				utente che intende acquistare l'abbonamento
	 * @param abbonamento
	 * 				abbonamento che si intende acquistare
	 * @param modalitàPagamento
	 * 				modalità di pagamento scelta dall'utente
	 * @return true se la il pagamento (e quindi l'acquisto dell'abbonamento) vanno a buon fine, false altrimenti
	 */
	public boolean scegliAbbonamento(Utente utente, Abbonamento abbonamento, String modalitàPagamento){
		if(!Pagamento.paga(utente, abbonamento, modalitàPagamento)){
			return false;
		}else{
			utente.getAbbonamentiPosseduti().add(abbonamento);
			return true;
		}
	}
	
	/**
	 * Metodo utilizzato per scrivere una recensione. Viene eseguito il metodo addRecensione presente in 
	 * {@link Volo}
	 * 
	 * @param utente
	 * 				utente che scrive la recensione
	 * @param volo
	 * 				volo su cui si sta scrivendo una recensione
	 * @param voto
	 * 				valutazione assegnata dall'utente al volo in questione
	 * @param descrizione
	 * 				descrizione fornita dall'utente riguardo al volo in questione
	 * @return true se l'aggiunta della recensione va a buon fine, false altrimenti
	 */
	public boolean scriviRecensione(Utente utente, Volo volo, int voto, String descrizione){
		return volo.addRecensione(utente, voto, descrizione);
	}
	
	/**
	 * Metodo usato per inserire un utente all'interno del sistema
	 * 
	 * @param utente
	 * 			utente da inserire
	 */
	public void addUtente(Utente utente){
		listaUtenti.add(utente);
	}
	
	/**
	 * Metodo usato per inserire un volo all'interno del sistema. Bisogna specificare anche per quanti giorni questo
	 * volo dovrà essere presente nel sistema
	 * 
	 * @param volo
	 * 			volo da inserire
	 * @param giorni
	 * 			numero di giorni in cui dovrà essere presente questo volo (partendo dal giorno di inserimento)
	 * @throws Exception in caso in cui non riesca ad eseguire il metodo getClone()
	 */
	public void addVolo(Volo volo, int giorni) throws Exception{
		volo.setData(2018, 1, 1);
		for(int i = 0; i < giorni; i++){
			Volo tmpVolo = volo;
			tmpVolo = (Volo)volo.getClone();
			Calendar cTemp = Calendar.getInstance();
			cTemp.set(2018, 1, 1);
			cTemp.add(Calendar.DAY_OF_MONTH, i);
			tmpVolo.setData(cTemp.get(Calendar.YEAR), cTemp.get(Calendar.MONTH), cTemp.get(Calendar.DAY_OF_MONTH));
			listaVoli.add(tmpVolo);
		}
	}	

	/**
	 * Metodo usato per inserire un abbonamento all'interno del sistema
	 * 
	 * @param abbonamento
	 * 			abbonamento da inserire
	 */
	public void addAbbonamento(Abbonamento abbonamento){
		listaAbbonamenti.add(abbonamento);
	}

}
