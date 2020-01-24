import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControllerShop {
	private boolean AccessoEffettuato;
	private ArrayList<Articolo> Magazzino;
	private ArrayList<Articolo> Carrello;

	public static void main(String[] args) {
		ControllerShop Controller = new ControllerShop();
		
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
		
		
		
	}	
	} 