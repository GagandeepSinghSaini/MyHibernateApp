package com.frys.inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sea_animal")
public class SeaAnimal extends Animal {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
