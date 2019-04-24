package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;
import com.infotel.services.Iservice;
import com.infotel.services.serviceImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private Iservice service = new serviceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1- récupération des données  
		
				String nom = null;        
				String prenom = null;        
				int age = 0;
				int id = 0;
				int idAdresse = 0;
				String login = null;
				String mdp = null;
				
			//Faire traitement A
				
				if(request.getParameter("nom")!=null) {            
					
					age = Integer.parseInt(request.getParameter("age"));            
					nom = request.getParameter("nom");           
					prenom = request.getParameter("prenom");
					
					login = request.getParameter("login"); 
					mdp = request.getParameter("mdp"); 
					idAdresse = Integer.parseInt(request.getParameter("idAdresse")); 
					
				}
				
		//2- envoyer à la couche service        
					
					Personne p = new Personne();       
					
					p.setAge(age);      
					p.setNom(nom);       
					p.setPrenom(prenom);  
					
					Connexion c = new Connexion ();
					c.setLogin(login);
					c.setMdp(mdp);
					
					p.setConnexion (c);
					
					if (idAdresse !=0) {
						p.setAdresse(service.getAdresse(idAdresse));
					}
					
					
					if(request.getParameter("ajouter")!=null) {            
						service.ajouterPersonne(p); 
						
						
					}       
					
					
					if(request.getParameter("modifier")!=null){          
						id = Integer.parseInt(request.getParameter("id"));          
						p.setId(id);
						service.modifierPersonne(p);       
					}
				  
		
				
		//3 - préparation à l'envoi  
				
				
				request.setAttribute("personnes", service.FindALLPersonne());
				request.setAttribute("adresses", service.FindALLAdresse());
		
		//4- appel de la jsp        
				
				request.getRequestDispatcher("Personne.jsp")  
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
