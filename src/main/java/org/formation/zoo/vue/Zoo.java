package org.formation.zoo.vue;

import java.util.List;
import java.util.Vector;

import org.formation.zoo.controleur.Manager;
import org.formation.zoo.modele.metier.*;
import org.formation.zoo.modele.technique.BeurkException;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.stockage.FichierAccess;

/**
 * Programme PRINCIPAL 
 * Contient le main
 * @author vi.samgmouit
 *
 */
public final class Zoo {
	public Zoo() {
		//Manager.getInstance();
	}
	
	public void afficher() {
		String[] infosAnimaux = Manager.getInstance().afficher();
		for(int i=0;i<infosAnimaux.length;i++)
		{
			System.out.println(infosAnimaux[i].toString());
		}
		
		/*Manager.getInstance().afficher().forEach(e->{
			System.out.println(e.toString());
		});*/
		
		//ArrayStoreException.asLManager.getInstance().afficher().
		//stream().forEach(System.out::println);
	}
	
	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir() {
		Manager.getInstance().nourrir();
	}
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passÃ©
	 */
	public void devorer(int mangeur, int mange) {
		System.out.println( Manager.getInstance().devorer(mangeur, mange));
	}
	
	public void ajouter(String codeAnimal, String nom, int age, double poids, int x, int y, int lgCornes) {
		System.out.println(Manager.getInstance().ajouter(codeAnimal, nom, age, poids, x, y, lgCornes));
	}
	/**
	 * 
	 * @param nom nom de l'animal à supprimer
	 */
	public void supprimer(String nom) {
		System.out.println(Manager.getInstance().supprimer(nom));
	}
	
	/*public void fermer() {
		Manager.getInstance().fermer();
	}*/
	
	public static void main(String[] args) {
		Zoo z = null;
		z = new Zoo();
					
	/*	z.afficher(); 
		System.out.println("on fait manger tous les animaux");
		z.nourrir();
		z.afficher();*/
		
	/*	System.out.println("on fait dévorer un animal");
		z.devorer(0, 1);
		z.afficher();*/
		
	/*	System.out.println("on ajoute un animal");
		z.ajouter("Gazelle", "Fetia", 7, 120, 300, 300, 12);
		z.afficher();*/
		
		System.out.println("on supprime un animal");
		z.supprimer("Fetia");
		z.afficher();
		
		System.out.println("on ferme le zoo");
	}

}
