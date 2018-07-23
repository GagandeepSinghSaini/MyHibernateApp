package com.frys.inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="animal")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	long animalId;
	String color;
	
	public long getAnimaId() {
		return animalId;
	}
	public void setAnimaId(long animalId) {
		this.animalId = animalId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
