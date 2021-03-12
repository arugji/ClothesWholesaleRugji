package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClothesWholesaleRugji;


/**
 * Servlet implementation class EditPhoneServlet
 */
@WebServlet("/editClothServlet")
public class EditClothServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClothServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		ListHelper dao = new ListHelper();
		String info1 = request.getParameter("info1");
		String info2 = request.getParameter("info2");
		
		Integer Id = Integer.parseInt(request.getParameter("id"));
		ClothesWholesaleRugji clothsToUpdate = dao.searchForClothById(Id);
		
		clothsToUpdate.setBrand(info1);
		clothsToUpdate.setItem(info2);
		dao.updateCloth(clothsToUpdate);
		getServletContext().getRequestDispatcher("/viewAllClothesServlet").forward(request, response);
	}

}
