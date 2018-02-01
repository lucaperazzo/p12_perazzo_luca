package myclasses;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Classe Utente
 * <p>
 * Classe che rappresenta gli utenti dell'applicazione. Comprende i valori inseriti in fase di registrazione e le liste
 * di prenotazioni, abbonamenti e pagamenti eseguiti durante l'utilizzo dell'applicazione.
 * 
 * @version 1.0
 * @author Luca Perazzo
 *
 */

public class Utente {

		private int id_utente;
		private String nome;
		private String cognome;
		private String username;
		private String password;
		private String email;
		private boolean autenticato;
		private double migliaAccumulate;
		
		private ArrayList<Prenotazione> listaPrenotazioni;		
		private ArrayList<Abbonamento> abbonamentiPosseduti;
		private ArrayList<Pagamento> pagamentiEffettuati;
		
		
		/**
		 * Costruttore di Utente: istanzia un nuovo oggetto utente impostandone i parametri che lo caratterizzano
		 * 
		 * @param id_utente
		 * 				identificativo utente
		 * @param nome 
		 * 				nome utente
		 * @param cognome
		 * 				cognome utente
		 * @param username
		 * 				username utente
		 * @param password 
		 * 				password utente
		 * @param email 
		 * 				email utente
		 */
		public Utente (int id_utente, String nome, String cognome, String username, String password,String email){
			this.setId_utente(id_utente);
			this.setNome(nome);
			this.setCognome(cognome);
			this.setUsername(username);
			this.setPassword(password);
			this.setEmail(email);
			this.setAutenticato(false);
			this.listaPrenotazioni = new ArrayList<Prenotazione>();
			this.abbonamentiPosseduti = new ArrayList<Abbonamento>();
			this.pagamentiEffettuati = new ArrayList<Pagamento>();
			this.migliaAccumulate = 0.0;
		}

		/**
		 * Metodo utilizzato per la restituzione del valore del campo id_utente
		 * 
		 * @return id_utente
		 */
		public int getId_utente() {
			return id_utente;
		}

		/**
		 * Metodo utilizzato per l'impostazione del campo id_utente
		 * 
		 * @param id_utente 
		 * 				identificativo utente
		 */
		public void setId_utente(int id_utente) {
			this.id_utente = id_utente;
		}

		/**
		 * Metodo utilizzato per la restituzione del valore del campo nome
		 * 
		 * @return nome
		 */
		public String getNome() {
			return nome;
		}
 
		/**
		 * Metodo utilizzato per l'impostazione del campo nome dell'utente
		 * 
		 * @param nome 
		 * 				nome utente
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}

		/**
		 * Metodo utilizzato per la restituzione del valore del campo cognome
		 * 
		 * @return cognome 
		 */
		public String getCognome() {
			return cognome;
		}

		/**
		 * Metodo utilizzato per l'impostazione del campo cognome dell'utente
		 * 
		 * @param cognome 
		 * 				cognome utente
		 */
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		/**
		 * Metodo utilizzato per la restituzione del valore del campo username
		 * 
		 * @return username 
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * Metodo utilizzato per l'impostazione del campo username dell'utente
		 * 
		 * @param username 
		 * 				username utente
		 */
		public void setUsername(String username) {
			this.username = username;
		}

		/**
		 * Metodo utilizzato per la restituzione del valore del campo password
		 * 
		 * @return password 
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Metodo utilizzato per l'impostazione del campo password dell'utente
		 * 
		 * @param password
		 * 				password utente
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * Metodo utilizzato per la restituzione del valore del campo email
		 * 
		 * @return email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * Metodo utilizzato per l'impostazione del campo email dell'utente
		 * 
		 * @param email 
		 * 				email utente
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * Metodo utilizzato per ritornare il valore booleano del flag autenticato dell'utente
		 * 
		 * @return autenticato
		 */
		public boolean isAutenticato() {
			return autenticato;
		}

		/**
		 * Metodo utilizzato per l'impostazione del flag autenticato dell'utente
		 * 
		 * @param autenticato 
		 * 					flag autenticato
		 */
		public void setAutenticato(boolean autenticato) {
			this.autenticato = autenticato;
		}
		
		/**
		 * Metodo utilizzato per la restituzione del valore attuale delle miglia accumulate dall'utente
		 * 
		 * @return migliaAccumulate
		 */
		public double getMigliaAccumulate() {
			return migliaAccumulate;
		}
		
		/**
		 * Metodo utilizzato per aggiungere miglia all'utente in seguito all'acquisto di un determinato volo
		 * 
		 * @param migliaVolo 
		 * 					quantità di miglia da aggiungere a quelle già possedute
		 */
		public void addMiglia(double migliaVolo){
			this.migliaAccumulate += migliaVolo;
		}
		
		/**
		 * Metodo utilizzato per la restituzione della lista di prenotazioni effettuate dall'utente
		 * 
		 * @return listaPrenotazioni
		 */
		public ArrayList<Prenotazione> getListaPrenotazioni() {
			return listaPrenotazioni;
		}
		
		/**
		 * Metodo utilizzato per la restituzione della lista di abbonamenti acquistati dall'utente
		 * 
		 * @return abbonamentiPosseduti
		 */
		public ArrayList<Abbonamento> getAbbonamentiPosseduti() {
			return abbonamentiPosseduti;
		}

		/**
		 * Metodo utilizzato per la restituzione della lista di pagamenti effettuati dall'utente
		 * 
		 * @return pagamentiEffettuati
		 */
		public ArrayList<Pagamento> getPagamentiEffettuati() {
			return pagamentiEffettuati;
		}

		/**
		 * Metodo che permette ad un utente di modificare i propri dati personali.
		 * @param nome 
		 * 			nome modificato dall'utente
		 * @param cognome
		 * 			cognome modificato dall'utente
		 * @param password 
		 * 			password modificata dall'utente
		 * @param email 
		 * 			email modificata dall'utente
		 * @return true se le modifiche vengono accettate dal sistema, false altrimenti
		 */
		public boolean modificaDati(String nome, String cognome, String password, String email){
			//controllare input?
			if(!nome.equals(""))
				this.nome = nome;
			else
				return false;
			if(!cognome.equals(""))
				this.cognome = cognome;
			else
				return false;
			if(!password.equals(""))
				this.password = password;
			else
				return false;
			if(!email.equals(""))
				this.email = email;
			else
				return false;
			return true;
		}
		
		/**
		 * Metodo che permette di stampare a video tutti i dati dell'utente corrente. In particolare verranno
		 * mostrati i dati inseriti dall'utente in fase di registrazione e le eventuali prenotazioni, recensioni,
		 * miglia accumulate, abbonamenti e pagamenti eseguiti dall'utente durante l'utilizzo del sistema.
		 * 
		 */
		public void visualizzaProfilo(){
			this.printInfoUtente();
			if(!this.listaPrenotazioni.isEmpty()){
				for(int i = 0; i < this.listaPrenotazioni.size(); i++){
					listaPrenotazioni.get(i).printInfoPrenotazione();
				}
			}
			if(!this.abbonamentiPosseduti.isEmpty()){
				for(int i = 0; i < this.abbonamentiPosseduti.size(); i++){
					abbonamentiPosseduti.get(i).printInfoAbbonamento();
				}
			}
			if(!this.pagamentiEffettuati.isEmpty()){
				for(int i = 0; i < this.pagamentiEffettuati.size(); i++){
					pagamentiEffettuati.get(i).printInfoPagamento();
				}
			}
		}
		
		/**
		 * Metodo utilizzato per cancellare una prenotazione dalle proprie prenotazioni possedute
		 * 
		 * @param p
		 * 			prenotazione che si intende rimuovere
		 * @return true se la prenotazione viene rimossa, false altrimenti
		 */
		public boolean destroyPrenotazione(Prenotazione p) {
			if(this.listaPrenotazioni.contains(p)){
				this.listaPrenotazioni.remove(p);
				return true;
			}else{
				return false;
			}
				
		}
		
		/**
		 * Metodo utilizzato per stampare a video i voli che l'utente può recensire
		 */
		public void visualizzaVoliDaRecensire() {
			ArrayList<Volo> voliDaRecensire = new ArrayList<Volo>();
			for(int i = 0; i<this.getListaPrenotazioni().size(); i++){
				if(Calendar.getInstance().after(this.getListaPrenotazioni().get(i).getVolo().getData())){
					voliDaRecensire.add(this.getListaPrenotazioni().get(i).getVolo());
					for(int j = 0; j < this.getListaPrenotazioni().get(i).getVolo().getListaRecensioni().size();
							j++){
						if(username.equals(this.getListaPrenotazioni().get(i).getVolo().getListaRecensioni().get(j).getUtente().getUsername())){
							voliDaRecensire.remove(this.getListaPrenotazioni().get(i).getVolo());
						}
					}
				}
			}
			for(int i = 0; i < voliDaRecensire.size(); i++){
				voliDaRecensire.get(i).printInfoVolo();
			}
		}
		
		/**
		 * Metodo utilizzato per stampare a video le informazioni di base dell'utente.
		 */
		public void printInfoUtente(){
			System.out.println("RIEPILOGO DATI UTENTE:\n" +
					"Nome: " + this.getNome() + 
					"\nCognome: " + this.getCognome() +
					"\nUsername: " + this.getUsername() + 
					"\nEmail: " + this.getEmail());
			System.out.println("Miglia Accumulate: " + this.migliaAccumulate);
		}
}
