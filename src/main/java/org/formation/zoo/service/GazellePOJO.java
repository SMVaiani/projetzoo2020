package org.formation.zoo.service;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gazelle database table.
 * 
 */
@Entity
@Table(name="gazelle")
public class GazellePOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAnimal")
	private CagePOJO idAnimal;

	private double lgCornes;

	public GazellePOJO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public CagePOJO getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(CagePOJO idAnimal) {
		this.idAnimal = idAnimal;
	}

	public double getLgCornes() {
		return this.lgCornes;
	}

	public void setLgCornes(double lgCornes) {
		this.lgCornes = lgCornes;
	}

}