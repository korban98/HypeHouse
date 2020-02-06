import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.Statement;
import java.util.ArrayList;

public class ControllerShop {
	private DAO dao;
	private boolean AccessoEffettuato;
	private ArrayList<Articolo> Magazzino;
	private boolean AccessoAdminEffettuato;
	private MagazzinoFrame magazframe;
	private ArrayList<Articolo> Carrello;
	private Utente UtenteConnesso;
	private LoginDialog login;
	private AggiungiArticoloDialog addarticolodialog;
	private NegozioDialog negoziodialog;
	private Double price;
	private Integer quantitaMagazzino;
	private Articolo art;
	private RegistrazioneDialog registrazione;
	private HomePageFrame homeframe;
	private static Connection con;
	private ResultSet rs;
	private CarrelloDialog carrellodialog;

	public ControllerShop() {
		dao = new DAO(this);
		homeframe = new HomePageFrame(this);
		login = new LoginDialog(this);
		registrazione = new RegistrazioneDialog(this);
		magazframe = new MagazzinoFrame(this);	
		homeframe.setVisible(true);
		addarticolodialog = new AggiungiArticoloDialog(this);
		negoziodialog=new NegozioDialog(this);
		carrellodialog=new CarrelloDialog(this);
		Magazzino = new ArrayList<Articolo>();
	}

	public static void main(String[] args) {
		ControllerShop Controller = new ControllerShop();  
	}

	public void VisibilitaLoginDialog(boolean flag) {
		login.setVisible(flag);
	}
	
	public void AggiungiArticoloDialog(boolean flag) {
		addarticolodialog.setVisible(flag);
	}
	
	public void NegozioDialog(boolean flag) {		
		negoziodialog.setVisible(flag);	
	}
	public void VisibilitaHome(boolean flag) {
		homeframe.setVisible(flag);
	}
	public void RitornaAllaHome() {
		homeframe.setVisible(true);
	}

	public void VisualizzaCarrelloDialog(boolean flag) {
		carrellodialog.setVisible(flag);
	}

	public void VisibilitaRegistrazioneDialog(boolean flag) {
		registrazione.setVisible(flag);
	}
	
	public void VisibilitaMagazzinoAdmin(String nomeadmin) {
		homeframe.setVisible(false);
		magazframe.SetLabelNomeAdmin(nomeadmin);
		magazframe.setVisible(true);
	    login.setVisible(false);
	}
	
	public void VisibilitaNegozioGuest() {
		login.setVisible(false);
		this.NegozioDialog(true);
		homeframe.setbottonelogout();
		homeframe.revalidate();
		homeframe.repaint();
		
	}
	
	public void ChiudiMagazzino() {
		homeframe.setVisible(true);
		magazframe.setVisible(false);
	}

	public void UpdateQuantitaMagazzinoAgg(int indexmagaz, int qnt) {
		Integer quantitaMagazzino = this.Magazzino.get(indexmagaz).getQuantita();
		quantitaMagazzino += qnt;
		this.Magazzino.get(indexmagaz).setQuantita(quantitaMagazzino); 
	}

	public String ControlloUtenteRegistrato(String username, String password) {
		String tipoutente = null;
		try {
			String qry= "SELECT TipoUtente FROM Utente WHERE Username = '"+username+"' AND Password = '"+password+"'";
			rs= dao.Select(qry);
			rs.next();
			tipoutente = rs.getString(1);
		}catch(Exception e) {System.out.println(e);}
		return tipoutente;
	}
	
	public void AggiungiArticoloDatabase(String codice, String genere, String categoria, String nome, String colore, String taglia, String prezzo, String quantita) {
		boolean success = false;
		try {
			String qry = "INSERT INTO Articolo VALUES ('"+codice+"','"+genere+"','"+categoria+"','"+nome+"','"+colore+"','"+taglia+"','"+prezzo+"','"+quantita+"')";
			success = dao.Update(qry);
			ControlloArticoloAggiunto(success);
		} catch (Exception e) {System.out.println(e);}
	}
	
	public void ErroreDialog(String messaggio, String titolo) {
		JOptionPane.showMessageDialog(new JFrame(), messaggio, titolo,
		        JOptionPane.ERROR_MESSAGE);
	}
	
	private void ControlloArticoloAggiunto(boolean success) {
		if(success==true) {
			JOptionPane.showMessageDialog(new JFrame(), "Articolo Aggiunto Correttamente al Database.", "",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			ErroreDialog("Articolo non aggiunto correttamente.", "Errore");
		}
	}

//	public void AggiungiArticoloMagazzino(String codbarre, String genere, String cat, String nome, String colore, String tag, String prezzo, String qnt) {
//		this.price = new Double(prezzo);
//		this.quantitaMagazzino = new Integer(qnt);
//		this.art = new Articolo(codbarre, genere, cat, nome,colore,tag,price,quantitaMagazzino);
//		Magazzino.add(art);	
//	}
} 