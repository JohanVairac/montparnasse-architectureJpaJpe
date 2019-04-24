package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class daoImpl implements Idao {
	
	//unité de persistance
	EntityManagerFactory emf;
	//porteur de requête
	EntityManager em;

	
//Personne
	
	@Override
public int ajouterPersonne(Personne p) {
	//ouverture unité de persistance et de transaction
	emf= Persistence.createEntityManagerFactory("demojpa-pu");
	em= emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	
	try {
		//1- ouvrir la transaction 
		tx.begin();
		//2- effectuer la requête
		em.persist(p);
		//3- valider la transaction
		tx.commit();
		//4- fermer l'unité de persistance
		em.close();
		emf.close();
	} catch (Exception e) {
		// annule la transaction
		tx.rollback();
	}
	return 0;
	
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Personne p= new Personne();
		
		try {
			p=em.getReference(Personne.class, idPersonne);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	
	public Personne affichagePersonne(int idPersonne) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Personne p= new Personne();
		
		try {
			p=em.find(Personne.class, idPersonne);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
		
	}
	
	
	@Override
	public int supprimerPersonne(Personne p) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- ouvrir la transaction 
			tx.begin();
			//2- effectuer la requête
			em.remove(p);
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return p.getId();
		
	}
	

	@Override
	public int modifierPersonne(Personne p) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- ouvrir la transaction 
			tx.begin();
			//2- effectuer la requête
			em.merge(p);
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return p.getId();

	}

	@Override
	public List<Personne> FindALLPersonne() {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Personne> l= new ArrayList<Personne>();
		try {
			q=em.createQuery("Select p from Personne p");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Personne> rechercherParMC(String mc) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Personne> l= new ArrayList<Personne>();
		try {
			q=em.createQuery("Select p from Personne p where nom like :lenom");
			q.setParameter("lenom", "%"+mc+"%");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	
//Adresse	
	
	@Override
	public int ajouterAdresse(Adresse a) {
		//ouverture unité de persistance et de transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		try {
			//1- ouvrir la transaction 
			tx.begin();
			//2- effectuer la requête
			em.persist(a);
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return 0;
	}

	
	@Override
	public Adresse getAdresse(int idAdresse) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Adresse a= new Adresse();
		
		try {
			a=em.getReference(Adresse.class, idAdresse);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Adresse affichageAdresse(int idAdresse) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Adresse a= new Adresse();
		
		try {
			a=em.find(Adresse.class, idAdresse);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- ouvrir la transaction 
			tx.begin();
			//2- effectuer la requête
			em.remove(a);
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return a.getIdAdresse();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- ouvrir la transaction 
			tx.begin();
			//2- effectuer la requête
			em.merge(a);
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return a.getIdAdresse();
	}

	@Override
	public List<Adresse> FindALLAdresse() {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Adresse> l= new ArrayList<Adresse>();
		try {
			q=em.createQuery("Select a from Adresse a");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Adresse> rechercherParMCAdresse(String mc) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Adresse> l= new ArrayList<Adresse>();
		try {
			q=em.createQuery("Select a from Adresse a where nomRue like :ladresse");
			q.setParameter("ladresse", "%"+mc+"%");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	
	
//Connexion
	
	@Override
	public int ajouterConnexion(Connexion c) {
		//ouverture unité de persistance et de transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				
				try {
					//1- ouvrir la transaction 
					tx.begin();
					//2- effectuer la requête
					em.persist(c);
					//3- valider la transaction
					tx.commit();
					//4- fermer l'unité de persistance
					em.close();
					emf.close();
				} catch (Exception e) {
					// annule la transaction
					tx.rollback();
				}
				return 0;
	}

	@Override
	public Connexion getConnexion(int idConnexion) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Connexion c= new Connexion();
		
		try {
			c=em.getReference(Connexion.class, idConnexion);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Connexion affichageConnexion(int idConnexion) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Connexion c= new Connexion();
		
		try {
			c=em.find(Connexion.class, idConnexion);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		//ouverture unité de persistance et de transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				
				try {
					//1- ouvrir la transaction 
					tx.begin();
					//2- effectuer la requête
					em.remove(c);
					//3- valider la transaction
					tx.commit();
					//4- fermer l'unité de persistance
					em.close();
					emf.close();
				} catch (Exception e) {
					// annule la transaction
					tx.rollback();
				}
				return c.getIdConnexion();
	}

	
	@Override
	public int modifierConnexion(Connexion c) {
		//ouverture unité de persistance et de transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		try {
			//1- ouvrir la transaction 
			tx.begin();
			//2- effectuer la requête
			em.merge(c);
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return c.getIdConnexion();
	}

	@Override
	public List<Connexion> FindALLConnexion() {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Connexion> l= new ArrayList<Connexion>();
		try {
			q=em.createQuery("Select c from Connexion c");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Connexion> rechercherParMCConnexion(String mc) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Connexion> l= new ArrayList<Connexion>();
		try {
			q=em.createQuery("Select c from Connexion c where mdp like :laconnexion");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public List<Personne> FindALLPersonnesConnexion() {
		
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Personne> l= new ArrayList<Personne>();
		try {
			q=em.createQuery("Select p from Personne p join p.connexion");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Personne> FindALLPersonnesAdresse() {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List<Personne> l= new ArrayList<Personne>();
		try {
			q=em.createQuery("Select p from Personne p full join p.adresse");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;	
	
	}
	

}
