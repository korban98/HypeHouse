import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerShop {
	private DAO dao;
	private MagazzinoFrame magazframe;
	private LoginDialog login;
	private AggiungiArticoloDialog addarticolodialog;
	private NegozioDialog negoziodialog;
	private Articolo art;
	private RegistrazioneDialog registrazione;
	private HomePageFrame homeframe;
	private ResultSet rs;
	private CarrelloDialog carrellodialog;
	public ModificaArticoloMagazFrame modificamagaz;
	private InfoArticoloDialog articolodialog;

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
		articolodialog=new InfoArticoloDialog(this);
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
	
	//il metodo controlla se l'utente inserito è salvato nel database e ritorna il suo tipo
	public String ControlloUtenteRegistrato(String username, String password) {
		String tipoutente = null;
		try {
			String qry= "SELECT TipoUtente FROM Utente WHERE Username = '"+username+"' AND Password = '"+password+"'";
			rs = dao.Select(qry);
			rs.next();
			tipoutente = rs.getString(1);
		}catch(Exception e) {System.out.println(e);}
		return tipoutente;
	}
	
	//il metodo restituisce la quantità nel database dell'articolo precedentemente selezionato
	public Integer getQuantitaArticoloDatabase(String codBarre) {
		String qnt = null;
		Integer quantita = new Integer(0);
		try {
			String qry = "SELECT Quantità FROM Articolo WHERE CodiceBarre = '"+codBarre+"'";
			rs = dao.Select(qry);
			rs.next();
			qnt = rs.getString(1);
			quantita = new Integer(qnt);
			return quantita;
		}catch(Exception e) {return quantita;}
	}
	
	private String ControlloPresenzaArticoloDatabase(String codice) {
		String articolopresente = null;
		try {
			String qry0 = "SELECT Nome FROM Articolo WHERE CodiceBarre = '"+codice+"'";
			rs = dao.Select(qry0);
			rs.next();
			articolopresente = rs.getString(1);
			return articolopresente;
		} catch (SQLException e) {return articolopresente;}	
	}
	
	//il metodo aggiunge un nuovo articolo al database controllando prima se l'articolo è già presente al suo interno
	public void AggiungiArticoloDatabase(String codice, String genere, String categoria, String nome, String colore, 
			String taglia, String prezzo, String quantita, File[] file) {
		boolean success = false;
		boolean successfoto = false;
		String articolopresente = null;
		try {
			articolopresente = ControlloPresenzaArticoloDatabase(codice);
			if(articolopresente==null) {
				String qry = "INSERT INTO Articolo VALUES ('"+codice+"','"+genere+"','"+categoria+"','"+nome+"','"+colore+"',"
						+ "'"+taglia+"','"+prezzo+"','"+quantita+"')";
				success = dao.Update(qry);
				if(success==true) {
					String qry1 = "INSERT INTO fotoarticolo (CodiceBarre,Foto) VALUES ('"+codice+"',?)";
					successfoto = dao.InsertImmagineDatabase(file, qry1);
				}
				ControlloArticoloAggiunto(success,successfoto);
			}
			else {
				ErroreDialog("Articolo già presente nel Database.", "Errore");
			}
		} catch (Exception e) {System.out.println(e);}
	}

	//il metodo modifica la quantità dell'articolo precedentemente selezionato nel database
	public boolean ModificaQuantitaArticoloDatabase(String quantita, String codbarre) {
		boolean modificaok = false;
		try{
			String qry = "UPDATE Articolo SET Quantità = '"+quantita+"' WHERE CodiceBarre = '"+codbarre+"'";
			modificaok = dao.Update(qry);
			return modificaok;
		}catch(Exception e) {System.out.println(e);}
		return modificaok;
	}
	
	//il metodo svuota completamente il database
	public boolean SvuotaMagazzinoDatabase() {
		boolean svuota = false;
		try{
			String qry = "DELETE FROM Articolo";
			svuota = dao.Update(qry);
			return svuota;
		}catch(Exception e) {System.out.println(e);}
		return svuota;
	}
	
	public File[] instanziaFileChooser() {
		File[] file = null;
		try{
			file = dao.PrelevaFileImage();
			return file;
		}catch (Exception e1) {return file;}
	}								
	
	//Dialog generica di errore
	public void ErroreDialog(String messaggio, String titolo) {
		JOptionPane.showMessageDialog(new JFrame(), messaggio, titolo,JOptionPane.ERROR_MESSAGE);
	}
	
	private void ControlloArticoloAggiunto(boolean success, boolean successfoto) {
		if((success==true)&&(successfoto==true)) {
			JOptionPane.showMessageDialog(new JFrame(), "Articolo aggiunto correttamente al Database.", "",
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
				art = new Articolo(rs.getString("CodiceBarre"), rs.getString("Genere"), rs.getString("Categoria"), 
						rs.getString("Nome"), rs.getString("Colore"), rs.getString("Taglia"), prezzo, quantita);

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
	}

	public boolean RimuoviArticoloMagazzino(String codbarre) {
		boolean eliminato = false;
		try {
			String qry = "DELETE FROM Articolo WHERE CodiceBarre = '"+codbarre+"'";
			eliminato = dao.Update(qry);
			return eliminato;
		} catch (Exception e) {return eliminato;}
	}
	
	//Registrazione nuovo utente se non è già registrato
	public void AggiungiUtenteDatabase(String username, String password, String tipo, String nome, String cognome, String email) {
		boolean success = false;
		String utenteregistrato = ControlloUtenteRegistrato(username, password);
		if(utenteregistrato == null) {
			String qry = "INSERT INTO Utente VALUES ('"+username+"','"+password+"','"+tipo+"','"+nome+"','"+cognome+"','"+email+"')";
			success = dao.Update(qry);
		}
		ControlloUtenteAggiunto(success,tipo);
	}
	
	private void ControlloUtenteAggiunto(boolean success, String tipo) {
		if((success==true)) {
			JOptionPane.showMessageDialog(new JFrame(), tipo+" registrato correttamente al Database.", "",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			ErroreDialog("Utente non registrato correttamente.", "Errore");
		}
	}
	
	public void VisibilitaArticoloDialog(boolean flag) {
		articolodialog.setVisible(flag);	
	}
} 