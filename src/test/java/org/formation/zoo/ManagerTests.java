package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.zoo.controleur.Manager;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;
import org.junit.jupiter.api.Test;

class ManagerTests {

	/*@Test
	void testGetAnimaux() {
		List<CagePOJO> res = Manager.getInstance().getAnimaux();
		double poidsGAGAG = res.get(0).getPoids();
		assertEquals("GAGAG 5 ans " + poidsGAGAG +  " kg", res.get(0).getPancarte());
		assertEquals("cage vide", res.get(4).getPancarte());
		assertEquals("./images/gazelle.gif", res.get(0).getImage());
		assertEquals("./images/cage.jpg", res.get(4).getImage());
		
		//FINIR LES TESTS!!!!!!!!!!!!!!!!!!!!!!
	}
	
	@Test
	void testAfficher() {
		String[] infosCageAnimaux = Manager.getInstance().afficher();
		List<CagePOJO> res = Manager.getInstance().getAnimaux();
		assertEquals("Cage [x=" + res.get(0).getX() + ", y=" + res.get(0).getY() + "]----Je suis un(e) " +
		res.get(0).getCodeAnimal() + " je m'appelle " + res.get(0).getNom() + " , j'ai " + res.get(0).getAge() +
		" ans, je p�se " + res.get(0).getPoids() + " kg, ses cornes mesurent 34 cm", infosCageAnimaux[0]);
	}
	
	@Test
	void testGetInstance() {
		assertNotNull(Manager.getInstance());
	}
	*/
	@Test
	void testNourir(){
		CagePOJO obj = null;
		obj = new CagePOJO();
		obj.setCodeAnimal("Lion");
		obj.setNom("Pai");
		obj.setAge(12);
		obj.setPoids(152.4);
		obj.setX(100);
		obj.setY(350);
		
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao();
		cp.ajouter(obj);
		
		List<CagePOJO> listcp = null;
		listcp = cp.lireTous();
		
		//Avant
		assertEquals(152.4, listcp.get(listcp.size()-1).getPoids());
		//Apr�s
		Manager.getInstance().nourrir();
		listcp = cp.lireTous();
		assertEquals(154.5, listcp.get(listcp.size()-1).getPoids());
		
		CagePOJO cagepojoLion = listcp.get(listcp.size()-1);
		cp.effacer(cagepojoLion);
	}

}
