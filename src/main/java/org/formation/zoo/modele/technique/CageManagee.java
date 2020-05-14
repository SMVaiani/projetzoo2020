package org.formation.zoo.modele.technique;

import java.util.ArrayList;
import java.util.List;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Gazelle;
import org.formation.zoo.modele.metier.Mangeable;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;
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
	private Dao<GazellePOJO> modeleGaz;
	
	public CageManagee(CagePOJO pojo, Dao<CagePOJO> dao, Dao<GazellePOJO> daoGaz) {
		modele = dao;
		modeleGaz = daoGaz;
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
		Animal a = this.controleur.sortir();

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
	 * @param mange la proie
	 * @return le texte sur ce qu'il s'est passée
	 */
	public String devorer(CageManagee mange) {
		Mangeable laBeteConvoitee = null;
		String s = "INCOMPATIBLE";
		if (mange.getOccupant() != null && this.getOccupant() != mange.getOccupant() && mange.getOccupant() instanceof Mangeable)
		{
			mange.ouvrir();
			try {
				laBeteConvoitee = (Mangeable) mange.sortir();
			} catch (PorteException e2) {
				s = e2.getMessage();
			}
			
			try {
				s = controleur.devorer(laBeteConvoitee);
				vue.setPoids(controleur.getOccupant().getPoids());
				modele.modifier(vue.getCle(), vue);
				modeleGaz.effacer(mange.vue.getGaz());
				mange.vue.setCodeAnimal(null);
				mange.vue.setNom(null);
				mange.vue.setAge(0);
				mange.vue.setPoids(0);
				mange.vue.setGaz(null);
				mange.modele.modifier(mange.vue.getCle(), mange.vue);
			} catch (BeurkException e1) {
				// TODO Auto-generated catch block
				s = e1.getMessage();
				try {
					mange.entrer((Animal)laBeteConvoitee);
				} catch (PorteException | CagePleineException e) {
					// TODO Auto-generated catch block
					s = e.getMessage();
				}
				mange.fermer();
			}
		}
		
		return s;
	}
	/**
	 * 
	 * @param a l'animal a faire entrer
	 * @return le texte sur ce qu'il s'est passée
	 */
	public String ajouter(Animal a) {
		String s = "Cage pleine";
		if(getOccupant() == null) {
			s = "Animal ajouter avec succès";
			try {
				entrer(a);
				fermer();
			} catch (PorteException | CagePleineException e) {
				// TODO Auto-generated catch block
				s = e.getMessage();
			}
			if(a instanceof Gazelle) 
			{
				GazellePOJO gazellePOJO = new GazellePOJO();
				gazellePOJO.setIdAnimal(vue.getCle());
				gazellePOJO.setLgCornes(((Gazelle)a).getLgCornes());
				vue.setGaz(gazellePOJO);
			}
			vue.setCodeAnimal(controleur.getOccupant().getClass().getSimpleName());
			vue.setNom(controleur.getOccupant().getNom());
			vue.setAge(controleur.getOccupant().getAge());
			vue.setPoids(controleur.getOccupant().getPoids());
			modele.modifier(vue.getCle(), vue);
		}
		
		return s;
	}
	/**
	 * 
	 * @return le texte sur ce qu'il s'est passée
	 */
	public String supprimer() {
		String s = "Cage vide";
		if(getOccupant() != null)
		{
			s = "Bye Bye l'animal";
			ouvrir();
			try {
			//	sortir();
				if(sortir() instanceof Gazelle)
				{
					modeleGaz.effacer(vue.getGaz());
				}
				vue.setCodeAnimal(null);
				vue.setNom(null);
				vue.setAge(0);
				vue.setPoids(0);
				vue.setGaz(null);
				modele.modifier(vue.getCle(), vue);
				
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
			tmp = String.join(" ", vue.getNom(),Integer.toString(vue.getAge()),"ans",Double.toString(vue.getPoids()),"kg ");
			if(vue.getCodeAnimal().equals("Gazelle"))
				tmp += String.join(" ", Integer.toString(vue.getGaz().getLgCornes()), " cm de cornes");
			vue.setPancarte(tmp);
			tmp = String.join("", IMAGES, vue.getCodeAnimal().toLowerCase()+".gif");
		}
		else
		{
			vue.setPancarte(String.join("", "cage vide [x=", Integer.toString(controleur.getX()), ", y=", Integer.toString(controleur.getY()), "]"));
			tmp = String.join("", IMAGES, "cage.jpg");
		}
		vue.setImage(tmp);
		return vue;
	}
}
