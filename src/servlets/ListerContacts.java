package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Contact;
import service.IService;
import service.IServiceImpl;

/**
 * Servlet implementation class ListerContacts
 */
@WebServlet("/ListerContacts")
public class ListerContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IService service = new IServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres

		
		// 2- traitements avec la couche service
		
		Collection<Contact> contacts = service.findAllContacts();
		
		// 3- préparation envoi
		request.setAttribute("contacts", contacts);
		// 4- envoi
		request.getRequestDispatcher("/listerContacts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
