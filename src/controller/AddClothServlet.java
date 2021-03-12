package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClothesWholesaleRugji;

/**
 * Servlet implementation class AddClothServlet
 */
@WebServlet("/addClothServlet")
public class AddClothServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClothServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	String info1 = request.getParameter("info1");
	String info2 = request.getParameter("info2");
	
	ClothesWholesaleRugji cw = new ClothesWholesaleRugji(info1, info2);
	ListHelper lh = new ListHelper();
	lh.insertCloth(cw);
	
	getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
