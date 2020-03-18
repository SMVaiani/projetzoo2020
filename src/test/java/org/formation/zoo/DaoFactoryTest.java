package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.stockage.DaoFactory;
import org.formation.zoo.stockage.TypeDao;
import org.junit.jupiter.api.Test;

class DaoFactoryTest {

	@Test
	void testGetInstance() {
		assertNotNull(DaoFactory.getInstance());
	}

	@Test
	void testGetDao() {
		assertNotNull(DaoFactory.getInstance().getDao(TypeDao.DAOJDBCIMPL));
		assertNotNull(DaoFactory.getInstance().getDao(TypeDao.DAOMEMOIRE));
	}

}
