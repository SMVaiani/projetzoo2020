package org.formation.zoo.modele.technique;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Mangeable;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.utilitaires.Conversion;

public final class CageManagee {
	/**
	 * chemin de l'image
	 */
	private final static String IMAGES="./images/";
	/**
	 * attribut de type Cage
	 */
	private Cage controleur;
	/**
	 * attribut de type CagePOJO
	 */
	private CagePOJO vue;
	private Dao<CagePOJO> modele;
	
	public CageManagee(CagePOJO pojo, Dao<CagePOJO> dao) {
		modele = dao;
		vue = pojo;
		controleur = Conversion.pojoToCage(pojo);
	}
	/**
	 * 
	 * @param a l'animal que l'on veut faire entrer
	 * @throws PorteException si la cage est fermée
	 * @throws CagePleineException si la cage est dèjà occupée
	 */
	public void entrer(Animal a) throws PorteException, CagePleineException {
			controleur.entrer(a);
			if(controleur.getOccupant() != null) {
				vue.setNom(controleur.getOccupant().getNom());
				vue.setAge(controleur.getOccupant().getAge());
				vue.setPoids(controleur.getOccupant().getPoids());
				vue.setCodeAnimal(controleur.getOccupant().getClass().getSimpleName());
				vue.setX(controleur.getX());
				vue.setY(controleur.getY());
				modele.ajouter(vue);
			}
			//mettre à jour le pojo
			//modifier le pojo
	}
	/**
	 * 
	 * @return l'animal qui était dans la cage
	 * Si la cage est vide retourne null
	 * @throws PorteException si la cage n'est pas ouverte
	 */
	public Animal sortir()throws PorteException {
		Animal a = controleur.sortir();
		if(controleur.getOccupant() == null) {
			vue.setCodeAnimal(null);
			vue.setNom(null);
			vue.setAge(0);
			vue.setPoids(0);
			modele.modifier(vue.getCle(), vue);
		}
		return a;
	}
	
	public void nourrir() {
		controleur.nourrir();
		if(controleur.getOccupant() != null) {
			vue.setPoids(controleur.getOccupant().getPoids());
			modele.modifier(vue.getCle(), vue);
		}
		//modele.modifier(vue)
	}
	
	/**
	 * 
	 * @param mange adresse de la proie
	 * @return le texte sur ce qu'il s'est passée
	 */
	public String devorer(CageManagee mange) {
		Mangeable laBeteConvoitee = null;
		String s = "INCOMPATIBLE";
		if (mange.getOccupant() != null && this.getOccupant() != null && mange.getOccupant() instanceof Mangeable)
		{
			mange.ouvrir();
			try {
				laBeteConvoitee = (Mangeable) mange.sortir();
			} catch (PorteException e2) {
				e2.printStackTrace();
			}
			
			s = controleur.devorer(laBeteConvoitee);
			if(s.equals("Je n'aime pas sa"))
			{
				try {
					mange.entrer((Animal)laBeteConvoitee);
				} catch (PorteException | CagePleineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			mange.fermer();
			
			if(s == "MIAM")
			{
				vue.setPoids(controleur.getOccupant().getPoids());
				modele.modifier(vue.getCle(), vue);
			}
		}
		
		return s;
	}
	public String supprimer() {
		String s = "Bye Bye";
		if(getOccupant() != null)
		{
			ouvrir();
			try {
				sortir();
			} catch (PorteException e) {
				s = e.getMessage();
			}
			fermer();
		}
		
		return s;
	}
	/**
	 * 
	 * @return l'animal occupant la cage
	 */
	public Animal getOccupant() {
		return controleur.getOccupant();
	}
	/**
	 * permet l'ouverture de la cage
	 */
	public void ouvrir() {
		controleur.ouvrir();
	}
	/**
	 * permet la fermeture de la cage
	 */
	public void fermer() {
		controleur.fermer();
	}
	
	@Override
	public String toString() {
		return controleur.toString();
	}
	/**
	 * 
	 * @return l'instance de CagePOJO
	 */
	public CagePOJO getVue() {
		String tmp = null;
		if(vue.getCodeAnimal() != null) {
			tmp = String.join(" ",vue.getNom(),Integer.toString(vue.getAge()),"ans",Double.toString(vue.getPoids()),"kg");
			vue.setPancarte(tmp);
			tmp = String.join("", IMAGES, vue.getCodeAnimal().toLowerCase()+".gif");
		}
		else
		{
			vue.setPancarte("cage vide");
			tmp = String.join("", IMAGES, "cage.jpg");
		}
		vue.setImage(tmp);
		return vue;
	}
}
