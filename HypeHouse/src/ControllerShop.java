import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerShop {
	private DAO dao;
	private MagazzinoFrame magazframe;
	private LoginDialog login;
	private AggiungiArticoloDialog addarticolodialog;
	public NegozioDialog negoziodialog;
	private Articolo articolo;
//	private FotoExstendsArticolo articolocompleto;
	private RegistrazioneDialog registrazione;
	public HomePageFrame homeframe;
	private ResultSet rs;
	public CarrelloDialog carrellodialog;
	public ModificaArticoloMagazFrame modificamagaz;
	public InfoArticoloDialog articolodialog;
	public static ControllerShop Controller;
	public ArrayList<FotoExstendsArticolo> ListaArticoli;
	public ArrayList<Articolo> carrello;
//	public ArrayList<ImageIcon> FotoArticoli;
	public CompletaOrdineDialog completaordine;
	public OrdineCompletatoDialog ordinecompletatodialog;

	public ControllerShop() {
		dao = new DAO(this);
		homeframe = new HomePageFrame(this);
		login = new LoginDialog(this);
		registrazione = new RegistrazioneDialog(this);
		magazframe = new MagazzinoFrame(this);	
		homeframe.setVisible(true);
		addarticolodialog = new AggiungiArticoloDialog(this);
		carrellodialog=new CarrelloDialog(this, null);
		carrello = new ArrayList<Articolo>();
		completaordine = new CompletaOrdineDialog(this, null, 0);
		ordinecompletatodialog = new OrdineCompletatoDialog(this);
//		ListaArticoli = new ArrayList<FotoExstendsArticolo>();
//		FotoArticoli = new ArrayList<ImageIcon>();
//		negoziodialog=new NegozioDialog(this);
//		System.out.println(ListaArticoli);
	}

	public static void main(String[] args) {
		Controller = new ControllerShop(); 
	}

	public void VisibilitaLoginDialog(boolean flag) {
		login.setVisible(flag);
	}
	
	public void RicaricaTutto() {
		Controller = new ControllerShop();
	}
	
	public void AggiungiArticoloDialog(boolean flag) {
		addarticolodialog.setVisible(flag);
	}
	
	public void VisibilitaNegozioDialog(boolean flag, String genere) {		
		negoziodialog.setVisible(flag);	
		negoziodialog.SetLabelSezione(genere);
	}
	
	public void VisibilitaHome(boolean flag) {
		homeframe.setVisible(flag);
	}
	
	public void RicaricaMagazzinoFrame() {
		magazframe.setVisible(false);
		magazframe.setVisible(true);
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
//		this.VisibilitaNegozioDialog(true);
//		negoziodialog.setVisible(true);
		homeframe.setbottonelogout();
		homeframe.revalidate();
		homeframe.repaint();
	}
//	
//	public void RefreshMagazzino() {
//		magazframe.setVisible(false);
//		magazframe.setVisible(true);
//	}
	
	//il metodo controlla se vi sono articoli nel carrello
	public boolean ControlloPresenzaArticoliCarrello(Utente user, double totale){
		boolean presente = false;
		int numeroart = carrello.size();
		if(numeroart != 0) {
			carrellodialog.setVisible(false);
			completaordine = new CompletaOrdineDialog(this, user, totale);
			completaordine.setVisible(true);
			presente = true;
		}
		return presente;
//		else
//			ErroreDialog("Non sono presenti articoli nel carrello.", "Errore");
	}
	
	public void ChiudiMagazzino() {
//		homeframe.setVisible(true);
		magazframe.setVisible(false);
	}
	
	//il metodo aggiunge all'ArrayList carrello un nuovo articolo con una data quantità
	public void AggiungiArticoloCarrello(FotoExstendsArticolo art, String qnt) {
		Integer quantita = new Integer(qnt);
		if((quantita <= art.getQuantita()) && (art.getQuantita() != 0)) {
				AddNuovoArticoloCarrello(art, quantita);
//				AggiornaQuantitaArticoloDatabase(art, quantita);
				setNuovaQuantita(art, quantita);
		}
		else
			ErroreDialog("Quantità inserita non presente.", "Errore.");
		}	
	
	//il metodo crea una nuova istanza di articolo viene settata la quantita e aggiunto all'ArrayList carrello
	public void AddNuovoArticoloCarrello(FotoExstendsArticolo art, int qnt) {
		Articolo tmp = new Articolo(null, null, null, null, null, null, null, qnt);
		tmp.setCategoria(art.getCategoria());
		tmp.setCodiceBarre(art.getCodiceBarre());
		tmp.setColore(art.getColore());
		tmp.setGenere(art.getGenere());
		tmp.setNome(art.getNome());
		tmp.setPrezzo(art.getPrezzo()*tmp.getQuantita());
//		tmp.setPrezzo(art.getPrezzo());
		tmp.setTaglia(art.getTaglia());
		tmp.setQuantita(qnt);
		carrello.add(tmp);
	}
	
	//il metodo modifica la quantità nel database dell'articolo aggiunto al carrello
	public void AggiornaQuantitaArticoloDatabase(FotoExstendsArticolo art,  int qnt) {
		try {
			setNuovaQuantita(art, qnt);
			String qry = "UPDATE Articolo SET Quantità = '"+art.getQuantita()+"' WHERE CodiceBarre = '"+art.getCodiceBarre()+"'";
			dao.Update(qry);
		} catch(Exception e) {System.out.println(e);}
	}
	
	//il metodo modifica la quantità logica di un articolo in magazzino dopo averlo aggiunto al carrello
	public void setNuovaQuantita(FotoExstendsArticolo art,  int qnt) {
		int nuovaqnt = art.getQuantita()-qnt;
		art.setQuantita(nuovaqnt);
		for(FotoExstendsArticolo articolo : ListaArticoli)
			if(articolo.equals(art))
				articolo.setQuantita(nuovaqnt);
	}
	
	//il metodo aggiunge la quantità richiesta al carrello di un articolo che è già stato aggiunto ad esso
	public void AggiungiQuantitaArticoloCarrello(FotoExstendsArticolo art, String qnt) {
		Integer quantita = new Integer(qnt);
		if((quantita <= art.getQuantita()) && (art.getQuantita() != 0)) {
			for(Articolo item : carrello)
				if(item.getCodiceBarre().equals(art.getCodiceBarre())) {
					int nuovaqnt = item.getQuantita()+quantita;
					item.setQuantita(nuovaqnt);
					item.setPrezzo(art.getPrezzo()*item.getQuantita());
					setNuovaQuantita(art, quantita);
				}
			}
	}
	
	//il metodo controlla la presenza dell'articolo selezionato nel carrello
	public boolean ControlloArticoloPresenteCarrello(FotoExstendsArticolo art) {
		boolean presente = false;
		for(Articolo articolo : carrello) {
			if(articolo.getCodiceBarre().equals(art.getCodiceBarre()))
				presente = true;
		}
		return presente;
	}
	
	//il metodo controlla se l'utente inserito è salvato nel database e ritorna il suo tipo
//	public String ControlloUtenteRegistrato(String username, String password) {
//		String tipoutente = null;
//		try {
//			String qry= "SELECT TipoUtente FROM Utente WHERE Username = '"+username+"' AND Password = '"+password+"'";
//			rs = dao.Select(qry);
//			rs.next();
//			tipoutente = rs.getString(1);
//		}catch(Exception e) {System.out.println(e);}
//		return tipoutente;
//	}
	
	public Utente ControlloUtenteRegistrato(String username, String password) {
		Utente user = new Utente(null, null, null, null, null, null);
		try {
			String qry= "SELECT * FROM Utente WHERE Username = '"+username+"' AND Password = '"+password+"'";
			rs = dao.Select(qry);
			rs.next();
			user = new Utente(rs.getString("Username"), rs.getString("Password"), rs.getString("TipoUtente"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Email"));
		}catch(Exception e) {System.out.println(e);}
		return user;
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
	
	//il metodo controlla se l'articolo è presente nel Database e ne restituisce il nome 
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
	
	//Il metodo restituisce un ArrayList contenente tutte le foto dal Database di un articolo
	public ArrayList<ImageIcon> PrelevaFoto(String codbarre) {
		ArrayList<ImageIcon> FotoArticoli=new ArrayList<ImageIcon>();
		try {
			ResultSet rs1;
			String qry = "SELECT Foto FROM FotoArticolo WHERE CodiceBarre = '"+codbarre+"'";
			rs1 = dao.Select(qry);
			while(rs1.next()) {
				byte[] fotobyte = rs1.getBytes("Foto");
				ImageIcon fotoimage = new ImageIcon(fotobyte);
				FotoArticoli.add(fotoimage);
			}	
			return FotoArticoli;
		} catch (Exception e) {return FotoArticoli;}
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
	
	public void AggiornaTabellaCarrello() {
		carrellodialog.SvuotaTabellaCarrello();
		for(Articolo art : carrello) {
			carrellodialog.AggiungiArticoloaTableCarrello(art);
		carrellodialog.setTotaleCarrello();
		}
	}
	
	//Il metodo aggiunge gli articoli alla tabella magazzino 
	public void AggiornaTabellaMagazzino(){
		try {
			String qry = "SELECT * FROM Articolo";
			rs = dao.Select(qry);
			while(rs.next()) {
				Double prezzo = new Double(rs.getString("Prezzo"));
				Integer quantita = new Integer(rs.getString("Quantità")) ;
				articolo = new Articolo(rs.getString("CodiceBarre"), rs.getString("Genere"), rs.getString("Categoria"), 
						rs.getString("Nome"), rs.getString("Colore"), rs.getString("Taglia"), prezzo, quantita);
				magazframe.AggiungiArticoloaTableMagazzino(articolo);
			}
		} catch (SQLException e) {System.out.println(e);}
	}
	
	//Il metodo popola un Array List di Articoli, comprese le foto associate presenti nel Database
	public ArrayList<FotoExstendsArticolo> getArrayArticoli(){
		try {
			ListaArticoli = new ArrayList<FotoExstendsArticolo>();
//			FotoArticoli.clear();
			String qry = "SELECT * FROM Articolo";
			rs = dao.Select(qry);
			while(rs.next()) {
				Double prezzo = new Double(rs.getString("Prezzo"));
				Integer quantita = new Integer(rs.getString("Quantità")) ;
				ArrayList<ImageIcon> Foto = PrelevaFoto(rs.getString("CodiceBarre"));
//				if(PrelevaFoto(rs.getString("CodiceBarre")) != null) {
				FotoExstendsArticolo articolocompleto = new FotoExstendsArticolo(rs.getString("CodiceBarre"), rs.getString("Genere"), rs.getString("Categoria"), 
						rs.getString("Nome"), rs.getString("Colore"), rs.getString("Taglia"), prezzo, quantita, Foto);
				ListaArticoli.add(articolocompleto);
//				}
//				else
//						ErroreDialog("ggggg", "fffff");
			}
			return ListaArticoli;
		} catch (Exception e) {return ListaArticoli;}
	}
	
	//il metodo richiamato alla conferma dell'ordine, controlla quali articoli ci sono nel carrello e ne riduce la quantità nel database
	public void ConfermaOrdine() {
		for(Articolo art : carrello) {
			for(FotoExstendsArticolo articolo : ListaArticoli) {
				if(art.getCodiceBarre().equals(articolo.getCodiceBarre())) {
					Integer nuovaqnt = articolo.getQuantita();
					ModificaQuantitaArticoloDatabase(nuovaqnt.toString() , articolo.getCodiceBarre());
				}
			}
		}
	}
	
	//il metodo salva l'ordine effettuato nel database
	public boolean SalvaOrdine(Double totale, String username, String indirizzo, String cap, String citta) {
		boolean confermato = false;
		try {
			String qry = "INSERT INTO ordine (Totale, Username, Indirizzo, CAP, Città) SELECT '"+totale.toString()+"' , u.Username, '"
					+indirizzo+"', '"+cap+"', '"+citta+"' FROM utente AS u WHERE u.Username = '"+username+"'";
			confermato = dao.Update(qry);
			return confermato;
		} catch (Exception e) {return confermato;}
	}
	
	//il metodo svuota la tabella presente in MagazzinoFrame
	public void SvuotaTabellaMgazzino() {
		DefaultTableModel dtm = (DefaultTableModel) magazframe.tableMagazzino.getModel();
		dtm.setRowCount(0);
	}
	
	public void SvuotaTabellaCarrello() {
//		DefaultTableModel dtm = (DefaultTableModel) carrellodialog.table.getModel();
//		dtm.setRowCount(0);
		carrello.clear();
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
		Utente utenteregistrato = ControlloUtenteRegistrato(username, password);
		if(utenteregistrato.getTipoUtente() == null) {
			String qry = "INSERT INTO Utente VALUES ('"+username+"','"+password+"','"+tipo+"','"+nome+"','"+cognome+"','"+email+"')";
			success = dao.Update(qry);
		}
		ControlloUtenteAggiunto(success,tipo);
	}
	
	//il metodo restituisce una dialog che ci conferma se l'utente è stato registrato o meno
	private void ControlloUtenteAggiunto(boolean success, String tipo) {
		if((success==true)) {
			JOptionPane.showMessageDialog(new JFrame(), tipo+" registrato correttamente al Database.", "",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			ErroreDialog("Utente non registrato correttamente.", "Errore");
		}
	}
	
	//Il metodo conta quanti articoli sono presenti nel Database per ogni Codice a Barre e restituisce il risultato in formato String
	public String ContaArticoliInDatabase(String genere) {
		String numeroarticoli = null;
		try {
			String qry = "SELECT COUNT(CodiceBarre) AS NumeroArticoli FROM Articolo WHERE Genere = '"+genere+"'";
			rs = dao.Select(qry);
			rs.next();
			numeroarticoli = rs.getString("NumeroArticoli");
			return numeroarticoli;
		} catch (SQLException e) {return numeroarticoli;}
	}
	
	//il metodo restituisce la somma totale dei prezzi degli articoli nel carrello
	public double SommaTotaleCarrello() {
		double tot=0;
		for(Articolo art : carrello)
				tot+=(art.getPrezzo());
		return tot;
	}
	
	//il metodo reimposta la quantità degli articoli nella ListaArticoli eliminati dal carrello
	public void ReimpostaQuantita(String codbarre, int quantita) {
		for(FotoExstendsArticolo art : ListaArticoli)
			if(art.getCodiceBarre().equals(codbarre)) {
				int qnt = art.getQuantita()+quantita;
				art.setQuantita(qnt);
				if(articolodialog.art.getCodiceBarre().equals(codbarre))
					articolodialog.ModificaQuantitaSpinner(qnt);
			}
	}
	
	public void RimuoviArticoloCarrello(int i) {
		carrello.remove(i);
	}
	
	public void setInfoArtDialog(FotoExstendsArticolo art) {
		articolodialog = new InfoArticoloDialog(this, art);
		negoziodialog.setVisible(false);
		articolodialog.setVisible(true);
	}
	
	public void VisibilitaArticoloDialog(boolean flag) {
		articolodialog.setVisible(flag);	
	}
} 