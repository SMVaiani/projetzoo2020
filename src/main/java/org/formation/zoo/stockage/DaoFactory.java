package org.formation.zoo.stockage;

import org.formation.zoo.service.CagePOJO;

public class DaoFactory {
	/**
	 * pour SINGLETON
	 */
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {
	}
	/**
	 * 
	 * @return l'instance unique du singleton
	 */
	public static DaoFactory getInstance() {
		return instance;
	}
	/**
	 * 
	 * @param typeDao choix du Dao(DaoJDBCImpl ou DaoMemoire)
	 * @return l'instance du Dao
	 */
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
