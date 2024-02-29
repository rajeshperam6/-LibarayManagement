package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		res.setContentType("text/HTML");
		PrintWriter out=res.getWriter();
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Connection con=DB_Connection.getcon();
		String q="select * from SignIn where email=?";
		try {
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String name="Admin";
				if(name.equals(rs.getString(1))) {
					RequestDispatcher rd=req.getRequestDispatcher("admin.html");
		    		rd.include(req,res);
				}
			else if(password.equals(rs.getString(3))) {
					out.println("<Center> <h3>Welcome! "+rs.getString(1)+"</h3></Center>");
					RequestDispatcher rd=req.getRequestDispatcher("home.html");
		    		rd.include(req,res);
				}else {
					out.println("<h1> Account Not Found</h1>");
					RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		    		rd.include(req,res);

				}
			}else {
				out.println("Sorry! Account Not found");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
	    		rd.include(req,res);

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
