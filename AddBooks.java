package files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		res.setContentType("text/HTML");
		BooksBean bb = new BooksBean();
		PrintWriter pw=res.getWriter();
		bb.setName(req.getParameter("BookName"));
		bb.setAuthorName(req.getParameter("AuthorName"));
		bb.setGenre(req.getParameter("Genre"));
		bb.setLanguage(req.getParameter("lang"));
		DAO_Class d=new DAO_Class();
		int k=d.insertBook(bb);
		if(k>0) {
    		//pw.println("Record Inserted successfully");
			pw.println("<center>Record Inseryed Successfully!</center>");
    		RequestDispatcher rd=req.getRequestDispatcher("add.html");
    		rd.include(req,res);
    	}else {
    		//pw.println(k);
    		pw.println("Record not Inserted");
    	}
	}

}
