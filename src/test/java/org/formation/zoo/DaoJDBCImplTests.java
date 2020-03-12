package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.DaoFactory;
import org.junit.jupiter.api.Test;

class DaoJDBCImplTests {

	@Test
	void testAjouter() {
		CagePOJO obj;
		obj = new CagePOJO();
		obj.setCodeAnimal("Lion");
		obj.setNom("Pai");
		obj.setAge(12);
		obj.setPoids(152.4);
		obj.setX(100);
		obj.setY(350);
		
		DaoFactory.getInstance().getDao().ajouter(obj);
	}

}
