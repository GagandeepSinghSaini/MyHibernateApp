package com.frys.mapping.OneToMany.bidirectional;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "cart_id")
	private long cartId;
	@Column(name = "cost")
	private long cost;
	@OneToMany(mappedBy = "cart")
	private Set<Item> cartItems;
	
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
	public Set<Item> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<Item> cartItems) {
		this.cartItems = cartItems;
	}
	
	
}
