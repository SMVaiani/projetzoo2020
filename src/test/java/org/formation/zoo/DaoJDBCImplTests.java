package org.formation.zoo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;
import org.junit.jupiter.api.Test;

class DaoJDBCImplTests {

	@Test
	void testAjouter() {
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
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		CagePOJO cagepojoLion = lcp.get(lcp.size()-1);
		assertEquals("Lion", cagepojoLion.getCodeAnimal());
		assertEquals("Pai", cagepojoLion.getNom());
		assertEquals(12, cagepojoLion.getAge());
		assertEquals(152.4, cagepojoLion.getPoids());
		assertEquals(100, cagepojoLion.getX());
		assertEquals(350, cagepojoLion.getY());
	}
	
	@Test
	void testModifier() {
		CagePOJO obj = null;
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao();
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		obj = lcp.get(lcp.size()-1);
		obj.setAge(15);
		obj.setPoids(182.3);
		cp.modifier(obj.getCle(), obj);
		
		assertEquals(15, obj.getAge());
		assertEquals(182.3, obj.getPoids());
	}
	
	@Test
	void testEffacerCagePojoObj() {
		CagePOJO obj = null;
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao();
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		int nbAnimalAvant = lcp.size();
		obj = lcp.get(lcp.size()-1);
		cp.effacer(obj);
		
		lcp = cp.lireTous();
		
		assertEquals(nbAnimalAvant-1, lcp.size());
	}
	
	@Test
	void testEffacerIntCle() {
		testAjouter();
		CagePOJO obj = null;
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao();
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		int nbAnimalAvant = lcp.size();
		obj = lcp.get(lcp.size()-1);
		cp.effacer(obj.getCle());
		
		lcp = cp.lireTous();
		
		assertEquals(nbAnimalAvant-1, lcp.size());
	}
	
	@Test
	void testLireTous() {
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao();
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		
		assertNotNull(lcp);
	}
}
