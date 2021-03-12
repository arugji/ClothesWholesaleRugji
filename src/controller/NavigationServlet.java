package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClothesWholesaleRugji;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		
		String act = request.getParameter("doThis");
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllClothesServlet";
		if (act.equals("delete")) {
			try {
				Integer clothId = Integer.parseInt(request.getParameter("id"));
				ClothesWholesaleRugji clothToDelete = dao.searchForClothById(clothId);
				dao.deleteCloth(clothToDelete);
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
				}
		} else if (act.equals("edit")) {
			try {
				Integer Id = Integer.parseInt(request.getParameter("id"));
				ClothesWholesaleRugji clothToEdit = dao.searchForClothById(Id);
				request.setAttribute("clothToEdit", clothToEdit);
			  path ="/editInfo.jsp";
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item.");
				}
		} else if (act.equals("add")) {
				path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
		}
	}


