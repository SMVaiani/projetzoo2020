package org.formation.zoo.stockage;

import org.formation.zoo.modele.metier.Cage;

public class DaoFactory {
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {
	}
	public static DaoFactory getInstance() {
		return instance;
	}
	public Dao<Cage> getDao(){
		return new FichierAccess<Cage>("zoo.data");
	}

}
