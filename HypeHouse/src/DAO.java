import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	private static Connection con;
	private ResultSet rs;
	private Statement stmt;
	
	public DAO(ControllerShop Controller) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con = DriverManager.getConnection(  
			"jdbc:mysql://den1.mysql1.gear.host:3306/hypehousedb","hypehousedb","!abc123!");
//			"jdbc:mysql://localhost:3306/mydb","root","!abc123!"    
			}catch(Exception e){ System.out.println(e);} 
	}
	
	public boolean Update(String qry) {
		try {
			stmt= con.createStatement();
			stmt.execute(qry);
			return true;
		} catch (SQLException e) {return false;}
	}
	
	public boolean updateQuery(String qry) {
		boolean flag=false;
		try {
			stmt= con.createStatement();
			flag = stmt.execute(qry);
			
			return flag;
		}catch(SQLException e) {
			return flag;
		}	
	}
	
	public ResultSet Select(String qry) {
		try {
			stmt= con.createStatement();
			rs = stmt.executeQuery(qry);
			return rs;
		} catch (SQLException e) {return null;}
	}
}
