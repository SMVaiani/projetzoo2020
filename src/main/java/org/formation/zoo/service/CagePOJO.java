package org.formation.zoo.service;

public class CagePOJO {
	/**
	 * Abscisse
	 */
	private int x;
	/**
	 * Ordonnée
	 */
	private int y;
	/**
	 * identifiant de l'animal
	 */
	private int cle;
	/**
	 * type de l'animal
	 */
	private String codeAnimal;
	/**
	 * nom de l'animal
	 */
	private String nom;
	/**
	 * age de l'animal
	 */
	private int age;
	/**
	 * poids de l'animal
	 */
	private double poids;
	/**
	 * instance de gazellePOJO
	 */
	private GazellePOJO gaz;
	/**
	 * Identité animal
	 */
	private String pancarte;
	/**
	 * Image correspondant à chaque animal
	 */
	private String image;
	
	public CagePOJO() {
		x = 0;
		y = 0;
		cle = 0;
		codeAnimal = null;
		nom = null;
		age = 0;
		poids = 0;
		gaz = null;
	}

	/**
	 * 
	 * @return infos animal
	 */
	public String getPancarte() {
		return pancarte;
	}

	/**
	 * 
	 * @param pancarte modifier infos animal
	 */
	public void setPancarte(String pancarte) {
		this.pancarte = pancarte;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public GazellePOJO getGaz() {
		return gaz;
	}

	public void setGaz(GazellePOJO gaz) {
		this.gaz = gaz;
	}

	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
		
	}

	public void setCle(int cle) {
		this.cle = cle;
		
	}

	public void setX(int x) {
		this.x = x;
		
	}

	public void setAge(int age) {
		this.age = age;
		
	}

	public void setPoids(double poids) {
		this.poids = poids;
		
	}

	public void setY(int y) {
		this.y = y;
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return type de l'animal
	 */
	public String getCodeAnimal() {
		return codeAnimal;
	}

	public String getNom() {
		return nom;
	}

	public int getAge() {
		return age;
	}

	public double getPoids() {
		return poids;
	}

	@Override
	public String toString() {
		return "CagePOJO [x=" + x + ", y=" + y + ", cle=" + cle + ", codeAnimal=" + codeAnimal + ", nom=" + nom
				+ ", age=" + age + ", poids=" + poids + "]" + gaz;
	}

	/**
	 * 
	 * @return identifiant de l'animal
	 */
	public int getCle() {
		return cle;
	}

}
