import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	private Articolo art;
	private RegistrazioneDialog registrazione;
	private HomePageFrame homeframe;
	private static Connection con;
	private ResultSet rs;
	private CarrelloDialog carrellodialog;
	public ModificaArticoloMagazFrame modificamagaz;

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
	
	public void RefreshMagazzino() {
		magazframe.setVisible(false);
		magazframe.setVisible(true);
	}
	
	public void ChiudiMagazzino() {
		homeframe.setVisible(true);
		magazframe.setVisible(false);
	}

//	public void UpdateQuantitaMagazzinoAgg(int indexmagaz, int qnt) {
//		Integer quantitaMagazzino = this.Magazzino.get(indexmagaz).getQuantita();
//		quantitaMagazzino += qnt;
//		this.Magazzino.get(indexmagaz).setQuantita(quantitaMagazzino); 
//	}

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
		boolean articolopresente = false;
		try {
			String qry0 = "SELECT CodiceBarre FROM Articolo WHERE CodiceBarre = '"+codice+"'";
			articolopresente = dao.Update(qry0);
			if(articolopresente==false) {
				String qry = "INSERT INTO Articolo VALUES ('"+codice+"','"+genere+"','"+categoria+"','"+nome+"','"+colore+"','"+taglia+"','"+prezzo+"','"+quantita+"')";
				success = dao.Update(qry);
				ControlloArticoloAggiunto(success);
			}
			else {
				ErroreDialog("Articolo già presente nel Database.", "Errore");
			}
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

	public void AggiornaTabellaMagazzino(){
		try {
			String qry = "SELECT * FROM Articolo";
			rs = dao.Select(qry);
			while(rs.next()) {
				Double prezzo = new Double(rs.getString("Prezzo"));
				Integer quantita = new Integer(rs.getString("Quantità")) ;
				art = new Articolo(rs.getString("CodiceBarre"), rs.getString("Genere"), rs.getString("Categoria"), rs.getString("Nome"),
					rs.getString("Colore"), rs.getString("Taglia"), prezzo, quantita);
				magazframe.AggiungiArticoloaTableMagazzino(art);
				
			}
		} catch (SQLException e) {System.out.println(e);}
	}

	public void SvuotaTabellaMgazzino() {
		DefaultTableModel dtm = (DefaultTableModel) magazframe.tableMagazzino.getModel();
		dtm.setRowCount(0);
	}

	public void ModificaArticoloMagazzino(String codbarre) {
		modificamagaz = new ModificaArticoloMagazFrame(this,codbarre);
		modificamagaz.setVisible(true);
//		modificamagaz.quantitaField.setText(codbarre);
	}

	public boolean RimuoviArticoloMagazzino(String codbarre) {
		boolean eliminato = false;
		try {
			String qry = "DELETE FROM Articolo WHERE CodiceBarre = '"+codbarre+"'";
			eliminato = dao.Update(qry);
			return eliminato;
		} catch (Exception e) {return eliminato;}
	}
} 