package files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import files.DB_Connection;
import files.BooksBean;
import files.BooksBean;

public class RetriveData {
	public ArrayList<BooksBean> al= new ArrayList<BooksBean>();
	public ArrayList<BooksBean> retriveData(){
		try {
			Connection Con=DB_Connection.getcon();
			PreparedStatement pst=Con.prepareStatement("select * from Books");
			ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				BooksBean pb= new BooksBean();
				pb.setName(rs.getString(1));
				pb.setAuthorName(rs.getString(2));
				pb.setGenre(rs.getString(3));
				pb.setLanguage(rs.getString(4));
				al.add(pb);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return al;
		}
}
