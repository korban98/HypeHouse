import java.util.ArrayList;
import javax.swing.ImageIcon;

public class FotoExtendsArticolo extends Articolo {
	private ArrayList<ImageIcon> FotoArticolo;
	
	//costruttore della classe derivata
	public FotoExtendsArticolo(String codbarre, String genere, String cat, String nome, String colore,
			String tag, Double prezzo, int qnt, ArrayList<ImageIcon> foto) {
		super(codbarre, genere, cat, nome, colore, tag, prezzo, qnt);
		setFotoArticolo(foto);
	}

	//getter e setter
	public ArrayList<ImageIcon> getFotoArticolo() {
		return this.FotoArticolo;
	}

	public void setFotoArticolo(ArrayList<ImageIcon> fotoArticolo) {
		this.FotoArticolo = fotoArticolo;
	}

	public ImageIcon getPrimaFotoArticolo() {
		return FotoArticolo.get(0);
	}
}
