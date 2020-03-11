public class Ordine {
	private String IdOrdine;
	private double Totale;
	private String Stato;
	private Utente user;
	private ControllerShop Controller;
	
	public Ordine(ControllerShop ctrl) {
		
		Controller=ctrl;
	}
	
	
	//getter and setter
	public String getIdOrdine() {
		return IdOrdine;
	}

	public String getStato() {
		return Stato;
	}

	public void setStato(String stato) {
		Stato = stato;
	}

}
