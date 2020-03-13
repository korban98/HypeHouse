import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;

public class DAO {
	private static Connection con;
	private ResultSet rs;
	private Statement stmt;
	
	//COSTRUTTORE
	public DAO(ControllerShop Controller) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con = DriverManager.getConnection(  
			"jdbc:mysql://den1.mysql1.gear.host:3306/hypehousedb","hypehousedb","!abc123!");   
			}catch(Exception e){ System.out.println(e);} 
	}
	
	//il metodo è usato per fare interrogazioni di modifica al Database 
	public boolean Update(String qry) {
		try {
			stmt= con.createStatement();
			stmt.execute(qry);
			return true;
		} catch (SQLException e) {return false;}
	}
	
	//il metodo è usato per prelevare le immagini dal sistema e le salva in un array File[]
	public File[] PrelevaFileImage() {
		try {
			File[] file=null;
			JFileChooser fc = new JFileChooser();
			fc.setMultiSelectionEnabled(true);
			int returnVal = fc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) { 
				  file = fc.getSelectedFiles(); //Array dove vengono salvate le foto selezionate
				  return file;
			}
			else return null;
			} catch (Exception e) {return null;}
	}
	
	//il metodo è usato per inserire le immagini nel Database
	public boolean InsertImmagineDatabase(File[] file, String qry) {
		boolean flag = false;
		try {
			  stmt= con.createStatement();
			  for(File cont : file) {
		  			PreparedStatement pstmt = con.prepareStatement(qry); // lettura del file
		  			FileInputStream input = new FileInputStream(cont); // set parametri file
		  			pstmt.setBinaryStream(1, input); 
		  			pstmt.executeUpdate();
		  			flag=true;
			  }
			  return flag;
		  } catch (Exception e1) {return flag;}
	}
	
	//il metodo è usato per fare interrogazioni di tipo select al Database
	public ResultSet Select(String qry) {
		try {
			stmt= con.createStatement();
			rs = stmt.executeQuery(qry);
			return rs;
		} catch (SQLException e) {return null;}
	}
}
