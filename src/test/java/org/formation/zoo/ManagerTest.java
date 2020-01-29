package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.controleur.Manager;
import org.junit.jupiter.api.Test;

class ManagerTest {

	@Test
	void testGetInstance() {
		Manager m = null;
		assertNotNull(Manager.getInstance());
		m = Manager.getInstance();
		assertEquals(m, Manager.getInstance());
		assertEquals(m, Manager.getInstance());
	}

}
