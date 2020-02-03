import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.sql.Statement;
import java.util.ArrayList;

public class ControllerShop {
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
	private CarrelloDialog carrellodialog;
	private Integer IndexMag;

	public ControllerShop() {
		homeframe = new HomePageFrame(this);
		login = new LoginDialog(this);
		registrazione = new RegistrazioneDialog(this);
		magazframe = new MagazzinoFrame(this);	
		homeframe.setVisible(true);
		addarticolodialog = new AggiungiArticoloDialog(this);
		negoziodialog=new NegozioDialog(this);
		carrellodialog=new CarrelloDialog(this);
	}

	public static void main(String[] args) {
		ControllerShop Controller = new ControllerShop();
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://www.db4free.net:3306/hypehousedb","korban98","!abc123!");
//			"jdbc:mysql://localhost:3306/mydb","root","!abc123!"  
			Statement stmt=con.createStatement();  
//			stmt.execute("INSERT INTO Utente values ('0','0','Admin','0','0','0')");  
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			//con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}

	public void VisibilitaLoginDialog() {
		login.setVisible(true);
	}
	
	public void AggiungiArticoloDialog() {
		addarticolodialog.setVisible(true);
	}
	
	public void NegozioDialog() {
		
		negoziodialog.setVisible(true);
		
	}
	
	public void RitornaAllaHome() {
		homeframe.setVisible(true);
		
	}
		
		
	public void AggiungiArticolo(String codbarre, String genere, String cat, String nome,String colore,String tag,String prezzo,String qnt) {
		this.price = new Double(prezzo);
		this.quantitaMagazzino = new Integer(qnt);
		this.art = new Articolo(codbarre, genere, cat, nome,colore,tag,price,quantitaMagazzino,null);
		Magazzino.add(art);
	
	}

	public void VisualizzaCarrelloDialog() {
		
		carrellodialog.setVisible(true);
	}
	
	
	public void VisibilitaRegistrazioneDialog(boolean flag) {
		registrazione.setVisible(flag);
	}
	
	public void VisibilitaMagazzinoAdmin() {
		magazframe.setVisible(true);
	    login.setVisible(false);
	}
	
	public void TipoUtenteLoggato() {
		    login.setVisible(false);
		    homeframe.setbottonelogout();
		    homeframe.revalidate();
		    homeframe.repaint();
	}
	
	public void UpdateQuantitaMagazzinoAgg(int indexmagaz, int qnt) {
		Integer quantitaMagazzino = this.Magazzino.get(indexmagaz).getQuantita();
		quantitaMagazzino += qnt;
		this.Magazzino.get(indexmagaz).setQuantita(quantitaMagazzino);
	}

	

	} 