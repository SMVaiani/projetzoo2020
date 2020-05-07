package org.formation.zoo.controleur;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Gazelle;
import org.formation.zoo.modele.metier.Mangeable;
import org.formation.zoo.modele.technique.BeurkException;
import org.formation.zoo.modele.technique.CageManagee;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;
import org.formation.zoo.stockage.FichierAccess;
import org.formation.zoo.stockage.TypeDao;
import org.formation.zoo.utilitaires.Conversion;

/**
 * SINGLETON et une FACADE
 * @author vi.samgmouit
 *
 */

public final class Manager {
	/**
	 * Vecteur de Cages. C'est la COMPOSITION.
	 */
	private List<CageManagee> lesCages;
	/**
	 * instance du dao choisi
	 */
	private Dao<CagePOJO> acces;
	private Dao<GazellePOJO> daoGaz;
	/**
	 * pour SINGLETON et une FACADE
	 */
	private static Manager instance = null;
	
	/**
	 * constructeur prive ==> SINGLETON
	 */
	private Manager() {
		lesCages = null;
		acces = DaoFactory.getInstance().getDao();
		daoGaz = DaoFactory.getInstance().getDaoGaz();
		init();
	}
	/**
	 * Singleton
	 * @return l'instance unique du singleton
	 */
	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	/**
	 * M√©thode priv√©e qui charge le mod√®le.
	 * Pour l'instant elle instancie les animaux
	 */
	private void init() {
		List<CagePOJO> tmp = null;
		tmp = acces.lireTous();
		lesCages = new ArrayList<CageManagee>();
		for(CagePOJO cagePOJO : tmp) {
			lesCages.add(new CageManagee(cagePOJO, acces, daoGaz));
		}
	}
	
	/**
	 * nourris tous les animaux du zoo
	 */
	public void nourrir () {
		for (CageManagee cageManagee : lesCages) {
			cageManagee.nourrir();
		}
	}
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est pass√©
	 */
	public String devorer(int mangeur, int mange) {	
		return lesCages.get(mangeur).devorer(lesCages.get(mange));
	}
	
	/**
	 * 
	 * @param codeAnimal type de l'animal
	 * @param nom nom de l'animal
	 * @param age age de l'animal
	 * @param poids poids de l'animal
	 * @param x positon x de la cage
	 * @param y position y de la cage
	 * @param lgCornes longueur de la cornes
	 * @return le texte sur ce qu'il s'est passÈe
	 */
	public String ajouter(String codeAnimal, String nom, int age, double poids, int x, int y, int lgCornes) {
		String s = "";
		for(CageManagee cm : lesCages) {
			if(cm.getVue().getX() == x && cm.getVue().getY() == y)
			{
				Animal animal = null;
				Class<?> classeAnimal;
				try {
					classeAnimal = Class.forName(String.join("", "org.formation.zoo.modele.metier.",codeAnimal));
					animal = (Animal) classeAnimal.getDeclaredConstructor().newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(animal instanceof Gazelle)
					((Gazelle) animal).setLgCornes(lgCornes);
				animal.setNom(nom);
				animal.setAge(age);
				animal.setPoids(poids);
				s = cm.ajouter(animal);
			}
		}
		
		return s;
	}
	/**
	 * 
	 * @param nom nom de l'animal ‡ supprimer
	 * @return le texte sur ce qu'il s'est passÈe
	 */
	public String supprimer(String nom) {
		String s = "Cet animal n'existe pas";
		for(CageManagee cm : lesCages) {
			if(cm.getVue().getNom() != null && cm.getVue().getNom().equals(nom))
			{
				s = cm.supprimer();
			}
		}
		
		return s;
	}
	
	/*public void fermer() {
		
		acces.ecrireTous(lesCages);
	}*/
	
	/**
	 * FACADE
	 * @return infos cage et animaux
	 */
	public String[] afficher() {
		String[] infosCageAnimaux = new String[lesCages.size()];
		for(int i=0; i<infosCageAnimaux.length;i++)
			infosCageAnimaux[i] = lesCages.get(i).toString();
		
		return infosCageAnimaux;
	}
	/**
	 * 
	 * @return une liste animaux
	 */
	public List<CagePOJO> getAnimaux(){
		List<CagePOJO> ret = null;
		ret = new Vector<CagePOJO>();
		for (CageManagee cm : lesCages) {
			ret.add(cm.getVue());
		}
		return ret;
	}
	
}
