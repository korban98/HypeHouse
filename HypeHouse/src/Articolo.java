public class Articolo {
	private String CodiceBarre;
	private String Genere;
	private String Categoria;
	private String Nome;
	private String Colore;
	private String Taglia;
	private Double Prezzo;
	private int Quantita;
	
	//COSTRUTTORE
	public Articolo(String codbarre, String genere, String cat, String nome, String colore, String tag,
			Double prezzo, int qnt) {
		setCodiceBarre(codbarre);
		setGenere(genere);;
		setCategoria(cat);;
		setNome(nome);
		setColore(colore);
		setTaglia(tag);
		setPrezzo(prezzo);
		setQuantita(qnt);

	}
	
	//getter e setter
	public String getCodiceBarre() {
		return CodiceBarre;
	}
	
	public void setCodiceBarre(String codbarre) {
		this.CodiceBarre = codbarre;
	}
	
	public String getGenere() {
		return Genere;
	}
	
	public void setGenere(String genere) {
		this.Genere = genere;
	}
	
	public String getCategoria() {
		return Categoria;
	}
	
	public void setCategoria(String categoria) {
		this.Categoria = categoria;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public String getColore() {
		return Colore;
	}
	
	public void setColore(String colore) {
		this.Colore = colore;
	}
	
	public String getTaglia() {
		return Taglia;
	}
	
	public void setTaglia(String taglia) {
		this.Taglia = taglia;
	}
	
	public Double getPrezzo() {
		return Prezzo;
	}
	
	public void setPrezzo(Double prezzo) {
		this.Prezzo = prezzo;
	}
	
	public int getQuantita() {
		return Quantita;
	}
	
	public void setQuantita(int quantita) {
		this.Quantita = quantita;
	}

}
