package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import files.BooksBean;
import files.RetriveData;


/**
 * Servlet implementation class ShowBooks
 */
@WebServlet("/ShowBooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		ArrayList<BooksBean> al= new RetriveData().retriveData();
		if(al.size()==0) {
			pw.println("Product are not available!!");
		}else {
			Iterator<BooksBean> it=al.iterator();
			pw.println("<center><h2>Book Name</h2></center>");
			while(it.hasNext()) {
				BooksBean pb=(BooksBean)it.next();
				pw.println("<center><h3>"+pb.getName()+"</h3></center>");
			}
		}
	}
}