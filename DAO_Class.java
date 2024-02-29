package files;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO_Class {
	int k=0;
	public int insert(Bean_Class db) {
		try {
			Connection con=DB_Connection.getcon();
			PreparedStatement pst=con.prepareStatement("insert into  SignIn values(?,?,?)");
			pst.setString(1,db.getName());
			pst.setString(2, db.getEmail());
			pst.setString(3, db.getPassword());
			k=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	public int insertBook(BooksBean b) {
		try {
			Connection con=DB_Connection.getcon();
			PreparedStatement pst=con.prepareStatement("insert into  Books values(?,?,?,?)");
			pst.setString(1, b.getName());
			pst.setString(2, b.getAuthorName());
			pst.setString(3, b.getGenre());
			pst.setString(4, b.getLanguage());
			k=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
}
