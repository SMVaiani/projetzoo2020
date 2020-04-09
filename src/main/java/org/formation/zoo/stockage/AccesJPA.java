package org.formation.zoo.stockage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccesJPA<T> implements Dao<T>{
	private EntityManager em;

	public AccesJPA() {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("projetzoo2020");
		em = emf.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> lireTous() {
		return em.createNamedQuery("findAll").getResultList();
	}

	@Override
	public T lire(int cle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ecrireTous(List<T> elts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(int cle, T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(int cle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(T obj) {
		// TODO Auto-generated method stub
		
	}
	
}
