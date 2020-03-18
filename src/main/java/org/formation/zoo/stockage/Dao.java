package org.formation.zoo.stockage;

import java.util.List;

public interface Dao<T> {
	/**
	 * 
	 * @return liste des animaux
	 */
	public List<T> lireTous();
	
	public void ecrireTous(List<T> elts);
	/**
	 * Pour modifier un animal par id et adresse
	 * @param cle identifiant de l'animal
	 * @param obj adresse de l'objet
	 */
	public void modifier(int cle, T obj);
	/**
	 * Pour effacer un aniaml par id
	 * @param cle identifiant de l'animal
	 */
	public void effacer(int cle);
	/**
	 * Pour effacer un animal par adresse
	 * @param obj adresse de l'objet
	 */
	public void effacer(T obj);
	/**
	 * Pour ajouter un animal par adresse
	 * @param obj adresse de l'objet
	 */
	public void ajouter(T obj);
}
