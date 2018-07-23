package com.frys.inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "land_animal")
public class LandAnimal extends Animal {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LandAnimal [name=" + name + ", animalId=" + animalId + ", color=" + color + "]";
	}

	
	
	
}
