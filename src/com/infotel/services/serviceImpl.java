package com.infotel.services;

import java.util.List;

import com.infotel.dao.Idao;
import com.infotel.dao.daoImpl;
import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class serviceImpl implements Iservice {

	private Idao dao = new daoImpl();
	
	
//Personne
	
	@Override
	public int ajouterPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.ajouterPersonne(p);
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.getPersonne(idPersonne);
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.supprimerPersonne(p);
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.modifierPersonne(p);
	}

	@Override
	public Personne affichagePersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.affichagePersonne(idPersonne);
	}

	@Override
	public List<Personne> FindALLPersonne() {
		// TODO Auto-generated method stub
		return dao.FindALLPersonne();
	}

	@Override
	public List<Personne> rechercherParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercherParMC(mc);
	}

	
//Adresse
	
	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.ajouterAdresse(a);
	}

	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return dao.getAdresse(idAdresse);
	}

	@Override
	public Adresse affichageAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return dao.affichageAdresse(idAdresse);
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.supprimerAdresse(a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.modifierAdresse(a);
	}

	@Override
	public List<Adresse> FindALLAdresse() {
		// TODO Auto-generated method stub
		return dao.FindALLAdresse();
	}

	@Override
	public List<Adresse> rechercherParMCAdresse(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercherParMCAdresse(mc);
	}

	
	
//Connexion
	
	@Override
	public int ajouterConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.ajouterConnexion(c);
	}

	@Override
	public Connexion getConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		return dao.getConnexion(idConnexion);
	}

	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		return dao.affichageConnexion(idConnexion);
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.supprimerConnexion(c);
	}

	@Override
	public int modifierConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.modifierConnexion(c);
	}

	@Override
	public List<Connexion> FindALLConnexion() {
		// TODO Auto-generated method stub
		return dao.FindALLConnexion();
	}

	@Override
	public List<Connexion> rechercherParMCConnexion(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercherParMCConnexion(mc);
	}

	public List<Personne> FindALLPersonnesConnexion() {
		return dao.FindALLPersonnesConnexion();
	
	}

	@Override
	public List<Personne> FindALLPersonnesAdresse() {
		// TODO Auto-generated method stub
		return dao.FindALLPersonnesAdresse();
	}

}
