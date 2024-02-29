package files;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	private static Connection con=null;
	private DB_Connection() {
		
	}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","exit");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getcon() {
		// TODO Auto-generated method stub
		return con;
	}
}
