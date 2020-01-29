package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.stockage.FichierAccess;
import org.junit.jupiter.api.Test;

class FichierAccessTest {

	@Test
	void testFichierAccess() {
		FichierAccess fa = new FichierAccess("esaie.data");
		assertEquals("esaie.data", fa.getFichier());
	}

}
