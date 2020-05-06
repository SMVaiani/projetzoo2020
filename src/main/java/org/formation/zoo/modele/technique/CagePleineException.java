package org.formation.zoo.modele.technique;

/**
 * Exception levÃ©e quand la  cage est occupÃ©e et quel'on veut faire entrer un animal
 * @author j.vincensini
 *
 */
public class CagePleineException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CagePleineException() {
		super("La cage est dèja  occupée");
	}

	public CagePleineException(String raison) {
		super(raison);
	}


}
