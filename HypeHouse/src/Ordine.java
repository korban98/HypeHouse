public class Ordine {
	private String IdOrdine;
	private double Totale;
	private String Stato;
	private String username;
	private String IndirizzoConsegna;
	private String CAP;
	private String citta;
	
	//COSTRUTTORE
	public Ordine(String idordine, double totale, String stato, String username, String indirizzo, String cap, String citta) {
		setIdOrdine(idordine);
		setTotale(totale);
		setStato(stato);
		setUsername(username);
		setIndirizzoConsegna(indirizzo);
		setCAP(cap);
		setCitta(citta);
	}

	//getter and setter
	public String getStato() {
		return Stato;
	}

	public void setStato(String stato) {
		Stato = stato;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCAP() {
		return CAP;
	}

	public void setCAP(String Cap) {
		CAP = Cap;
	}

	public String getIndirizzoConsegna() {
		return IndirizzoConsegna;
	}

	public void setIndirizzoConsegna(String indirizzoConsegna) {
		IndirizzoConsegna = indirizzoConsegna;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotale() {
		return Totale;
	}

	public void setTotale(double totale) {
		Totale = totale;
	}

	public String getIdOrdine() {
		return IdOrdine;
	}

	public void setIdOrdine(String idOrdine) {
		IdOrdine = idOrdine;
	}

}
