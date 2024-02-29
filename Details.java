package files;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import files.Bean_Class;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		res.setContentType("text/HTML");
		Bean_Class BC= new Bean_Class();
		PrintWriter pw=res.getWriter();
		BC.setName(req.getParameter("name"));
		BC.setEmail(req.getParameter("email"));
		BC.setPassword(req.getParameter("password"));
		DAO_Class d=new DAO_Class();
		int k=d.insert(BC);
		if(k>0) {
    		//pw.println("Record Inserted successfully");
			pw.println("<center>Account Created Successfully!</center>");
    		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
    		rd.include(req,res);
    	}else {
    		pw.println(k);
    		pw.println("Record not Inserted");
    	}
	}

}
