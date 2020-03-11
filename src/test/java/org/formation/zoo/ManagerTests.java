package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.zoo.controleur.Manager;
import org.formation.zoo.service.CagePOJO;
import org.junit.jupiter.api.Test;

class ManagerTests {

	@Test
	void testGetAnimaux() {
		List<CagePOJO> res = Manager.getInstance().getAnimaux();
		double poidsGAGAG = res.get(0).getPoids();
		assertEquals("GAGAG 5 ans " + poidsGAGAG +  " kg", res.get(0).getPancarte());
		assertEquals("cage vide", res.get(4).getPancarte());
		assertEquals("./images/gazelle.gif", res.get(0).getImage());
		assertEquals("./images/cage.jpg", res.get(4).getImage());
		
		//FINIR LES TESTS!!!!!!!!!!!!!!!!!!!!!!
	}

}
