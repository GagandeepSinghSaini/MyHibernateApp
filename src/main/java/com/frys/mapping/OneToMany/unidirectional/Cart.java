package com.frys.mapping.OneToMany.unidirectional;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity (name = "com.frys.mapping.OneToMany.unidirectional.Cart")
@Table (name = "cart1")
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "cart_id")
	private long cartId;
	@Column(name = "cost")
	private long cost;
	
	
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}	

	
}
