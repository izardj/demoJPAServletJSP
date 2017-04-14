package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Adresse;
import metier.Contact;
import service.IService;
import service.IServiceImpl;

/**
 * Servlet implementation class AjouterContactAdresse
 */
@WebServlet("/AjouterContactAdresse")
public class AjouterContactAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IService service = new IServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterContactAdresse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String codePostal = request.getParameter("codepostal");
		
		// 2- traitements avec la couche service
		Adresse a = new Adresse();
		a.setNumRue(rue);
		a.setVille(ville);
		a.setCodePostal(codePostal);
		
		Contact c = new Contact();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setAdresse(a);
		
		service.ajouterContactAdresse(c, a);
		
		Collection<Contact> contacts = service.findAllContacts();
		// 3- préparation envoi
		request.setAttribute("contacts", contacts);
		// 4- envoi
		request.getRequestDispatcher("/ajouterListerContact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
