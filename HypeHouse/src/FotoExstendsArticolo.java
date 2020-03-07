import java.util.ArrayList;
import javax.swing.ImageIcon;

public class FotoExstendsArticolo extends Articolo {
	private ArrayList<ImageIcon> FotoArticolo;
	
	//costruttore della classe derivata
	public FotoExstendsArticolo(String codbarre, String genere, String cat, String nome, String colore,
			String tag, Double prezzo, int qnt, ArrayList<ImageIcon> foto) {
		super(codbarre, genere, cat, nome, colore, tag, prezzo, qnt);
		setFotoArticolo(foto);
	}

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
