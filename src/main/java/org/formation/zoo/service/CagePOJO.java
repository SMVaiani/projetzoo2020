package org.formation.zoo.service;

public class CagePOJO {
	private int x;
	private int y;
	private int cle;
	private String codeAnimal; // type de l'animal
	private String nom;
	private int age;
	private double poids;
	
	public CagePOJO() {
		x = 0;
		y = 0;
		cle = 0;
		codeAnimal = null;
		nom = null;
		age = 0;
		poids = 0;
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

	public Object getCodeAnimal() {
		return codeAnimal;
	}

	public Object getNom() {
		return nom;
	}

	public Object getAge() {
		return age;
	}

	public Object getPoids() {
		return poids;
	}

}
