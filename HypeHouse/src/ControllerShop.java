import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControllerShop {
	private boolean AccessoAdminEffettuato;
	private MagazzinoFrame magazframe;
	private ArrayList<Articolo> Magazzino;
	private ArrayList<Articolo> Carrello;
	private Utente UtenteConnesso;
	private LoginDialog login;
	private RegistrazioneDialog registrazione;
	private HomePageFrame homeframe;

	public ControllerShop() {
		homeframe = new HomePageFrame(this);
		login = new LoginDialog(this);
		registrazione = new RegistrazioneDialog(this);
		magazframe = new MagazzinoFrame(this);	
		homeframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		ControllerShop Controller = new ControllerShop();
		
		//carica il driver
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/mydb","root","!abc123!");    
			Statement stmt=con.createStatement();  
//			stmt.execute("INSERT INTO autore values ('111','marco','rossi')");  
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			//con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}

	public void VisibilitaLoginDialog() {
		login.setVisible(true);
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
	} 