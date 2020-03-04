package org.formation.zoo.stockage;

import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.service.CagePOJO;

public class DaoFactory {
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {
	}
	public static DaoFactory getInstance() {
		return instance;
	}
	public Dao<CagePOJO> getDao(){
		//return new FichierAccess<Cage>("zoo.data");
		//return new DaoJDBCImpl();
		return new DaoMemoire();
	}

}
