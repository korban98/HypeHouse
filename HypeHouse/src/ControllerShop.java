import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.sql.Statement;
import java.util.ArrayList;

public class ControllerShop {
	private boolean AccessoEffettuato;
	private ArrayList<Articolo> Magazzino;
	private Utente UtenteConnesso;
	private HomePageFrame homeframe;
	private LoginDialog login;
	private AggiungiArticoloDialog addarticolodialog;
	private NegozioDialog negoziodialog;
	private Double price;
	private Integer quantitaMagazzino;
	private Articolo art;
	
	public static void main(String[] args) {
		ControllerShop Controller = new ControllerShop();
		
		
		HomePageFrame frame = new HomePageFrame(Controller);
		frame.setVisible(true);
		
		
		//carica il driver
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/mydb","root","!abc123!");    
			Statement stmt=con.createStatement();  
			stmt.execute("INSERT INTO autore values ('111','marco','rossi')");  
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			//con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}
	
	
	public ControllerShop() {
		homeframe =new HomePageFrame(this);
		login = new LoginDialog(this);
//		login.setVisible(true);	
		addarticolodialog = new AggiungiArticoloDialog(this);
		negoziodialog=new NegozioDialog(this);
		Magazzino = new ArrayList<Articolo>();
	}	
	
	public void AccessoLoginDialog() {
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


	
	
	
	
	} 