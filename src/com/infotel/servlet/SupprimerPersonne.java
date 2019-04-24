package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.services.Iservice;
import com.infotel.services.serviceImpl;


/**
 * Servlet implementation class SupprimerPersonen
 */
@WebServlet("/SupprimerPersonne")
public class SupprimerPersonne extends HttpServlet {
	private Iservice service = new serviceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1 - Récupération des données                        
		
			int id = Integer.parseInt(request.getParameter("id"));
		
		 //2 - Envoyer à la couche service                               
			Personne p = new Personne();               
			p =service.getPersonne(id);               
			service.supprimerPersonne(p);
			
			//3 - Préparation à l'envoi                                
			
			request.setAttribute("personnes", service.FindALLPersonne());                       
			
			//4 - Envoi à la JSP                               
			request.getRequestDispatcher("Personne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
