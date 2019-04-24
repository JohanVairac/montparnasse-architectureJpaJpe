package com.infotel.services;

import java.util.List;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public interface Iservice {
	
	public int ajouterPersonne(Personne p);
	public Personne getPersonne (int idPersonne);
	public Personne affichagePersonne (int idPersonne);
	public int supprimerPersonne (Personne p);
	public int modifierPersonne (Personne p);
	public List<Personne> FindALLPersonne();
	public List<Personne> rechercherParMC(String mc);
	public List<Personne> FindALLPersonnesConnexion();
	public List<Personne> FindALLPersonnesAdresse();
	
	
	public int ajouterAdresse(Adresse a);
	public Adresse getAdresse (int idAdresse);
	public Adresse affichageAdresse (int idAdresse);
	public int supprimerAdresse (Adresse a);
	public int modifierAdresse (Adresse a);
	public List<Adresse> FindALLAdresse();
	public List<Adresse> rechercherParMCAdresse(String mc);
	
	
	public int ajouterConnexion(Connexion c);
	public Connexion getConnexion (int idConnexion);
	public Connexion affichageConnexion (int idConnexion);
	public int supprimerConnexion (Connexion c);
	public int modifierConnexion (Connexion c);
	public List<Connexion> FindALLConnexion();
	public List<Connexion> rechercherParMCConnexion(String mc);
}
