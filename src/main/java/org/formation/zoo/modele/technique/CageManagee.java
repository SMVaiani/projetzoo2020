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
	public void entrer(Animal a) throws PorteException, CagePleineException{
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
	
	public Animal sortir()throws PorteException
	{
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
	
	public String devorer(CageManagee mange)
	{
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
			if(s == "Je n'aime pas sa")
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
	
	/**/
	public Animal getOccupant() {
		return controleur.getOccupant();
	}
	
	public void ouvrir()
	{
		controleur.ouvrir();
	}
	public void fermer()
	{
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
