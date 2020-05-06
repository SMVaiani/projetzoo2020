package org.formation.zoo.modele.technique;

/**
 * Exception levée quand la porte d'une cage est fermée et qu'on veut faire entrer ou soritr un animal
 * @author j.vincensini
 *
 */
public class PorteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PorteException() {
		super("Probl�me de porte");
	}

	public PorteException(String raison) {
		super(raison);
	}


}
