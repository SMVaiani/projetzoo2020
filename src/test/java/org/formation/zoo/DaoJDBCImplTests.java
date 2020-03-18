package org.formation.zoo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;
import org.formation.zoo.stockage.TypeDao;
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
		
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao(TypeDao.DAOJDBCIMPL);
		cp.ajouter(obj);
		
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		CagePOJO cagepojoLion = lcp.get(lcp.size()-1);
		cp.effacer(cagepojoLion);
		
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
		obj = new CagePOJO();
		obj.setCodeAnimal("Lion");
		obj.setNom("Pai");
		obj.setAge(12);
		obj.setPoids(152.4);
		obj.setX(100);
		obj.setY(350);
		
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao(TypeDao.DAOJDBCIMPL);
		cp.ajouter(obj);
		
		List<CagePOJO> listcp = null;	
		listcp = cp.lireTous();
		obj = listcp.get(listcp.size()-1);
		// modifier
		obj.setAge(15);
		obj.setPoids(182.3);
		cp.modifier(obj.getCle(), obj);
		
		listcp = cp.lireTous();
		cp.effacer(obj);
		
		assertEquals(15, listcp.get(listcp.size()-1).getAge());
		assertEquals(182.3, listcp.get(listcp.size()-1).getPoids());
	}
	
	@Test
	void testEffacerCagePojoObj() {
		
		CagePOJO obj = null;
		obj = new CagePOJO();
		obj.setCodeAnimal("Lion");
		obj.setNom("Pai");
		obj.setAge(12);
		obj.setPoids(152.4);
		obj.setX(100);
		obj.setY(350);
		
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao(TypeDao.DAOJDBCIMPL);
		cp.ajouter(obj);
		
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		int nbAnimalAvant = lcp.size();
		CagePOJO cagepojoLion = lcp.get(lcp.size()-1);
		cp.effacer(cagepojoLion);	
		lcp = cp.lireTous();
		
		assertEquals(nbAnimalAvant-1, lcp.size());
	}
	
	@Test
	void testEffacerIntCle() {

		CagePOJO obj = null;
		obj = new CagePOJO();
		obj.setCodeAnimal("Lion");
		obj.setNom("Pai");
		obj.setAge(12);
		obj.setPoids(152.4);
		obj.setX(100);
		obj.setY(350);
		
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao(TypeDao.DAOJDBCIMPL);
		cp.ajouter(obj);
		
		List<CagePOJO> lcp = null;
		lcp = cp.lireTous();
		int nbAnimalAvant = lcp.size();
		CagePOJO cagepojoLion = lcp.get(lcp.size()-1);
		cp.effacer(cagepojoLion.getCle());
		
		lcp = cp.lireTous();
		
		assertEquals(nbAnimalAvant-1, lcp.size());
	}
	
	@Test
	void testLireTous() {
		Dao<CagePOJO> cp = DaoFactory.getInstance().getDao(TypeDao.DAOJDBCIMPL);
		List<CagePOJO> listcp = null;
		listcp = cp.lireTous();
		
		assertNotNull(listcp);
	}
}
