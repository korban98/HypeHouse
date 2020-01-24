import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Articolo {
	private int CodiceBarre;
	private String Genere;
	private String Categoria;
	private String Nome;
	private String Colore;
	private String Taglia;
	private double Prezzo;
	private int Quantita;
	private ArrayList<ImageIcon> FotoArticolo;
	
	public Articolo(int codbarre, String genere, String cat, String nome, String colore, String tag, double prezzo, int qnt, ArrayList<ImageIcon> foto) {
		this.setCodiceBarre(codbarre);
		this.setGenere(genere);
		this.setCategoria(cat);
		this.setNome(nome);
		this.setColore(colore);
		this.setTaglia(tag);
		this.setPrezzo(prezzo);
		this.setQuantita(qnt);
		this.setFotoArticolo(foto);
	}
	
	//getter and setter
	public int getCodiceBarre() {
		return CodiceBarre;
	}
	
	public void setCodiceBarre(int codiceBarre) {
		CodiceBarre = codiceBarre;
	}
	
	public String getGenere() {
		return Genere;
	}
	
	public void setGenere(String genere) {
		Genere = genere;
	}
	
	public String getCategoria() {
		return Categoria;
	}
	
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getColore() {
		return Colore;
	}
	
	public void setColore(String colore) {
		Colore = colore;
	}
	
	public String getTaglia() {
		return Taglia;
	}
	
	public void setTaglia(String taglia) {
		Taglia = taglia;
	}
	
	public double getPrezzo() {
		return Prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}
	
	public int getQuantita() {
		return Quantita;
	}
	
	public void setQuantita(int quantita) {
		Quantita = quantita;
	}
	
	public ArrayList<ImageIcon> getFotoArticolo() {
		return FotoArticolo;
	}
	
	public void setFotoArticolo(ArrayList<ImageIcon> fotoArticolo) {
		
		
		
	}
}
