public class Ordine {
	private String IdOrdine;
	private double Totale;
	private String Stato;
	private ControllerShop Controller;
	
	public Ordine(ControllerShop ctrl) {
		this.Controller=ctrl;
	}
	
	
	//getter and setter
	public String getIdOrdine() {
		return IdOrdine;
	}

	public String getStato() {
		return Stato;
	}

	public void setStato(String stato) {
		
		
	
	}

}
