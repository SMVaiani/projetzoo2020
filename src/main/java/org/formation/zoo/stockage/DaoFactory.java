package org.formation.zoo.stockage;

import org.formation.zoo.service.CagePOJO;

public class DaoFactory {
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {
	}
	public static DaoFactory getInstance() {
		return instance;
	}
	public Dao<CagePOJO> getDao(TypeDao typeDao){
		
		switch (typeDao) {
		case DAOJDBCIMPL:
			return new DaoJDBCImpl();
		case DAOMEMOIRE:
			return new DaoMemoire();
		default:
			return null;
		}
//		return new FichierAccess<Cage>("zoo.data");
	}

}
