package com.frys.mapping.OneToMany.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity (name = "com.frys.mapping.OneToMany.unidirectional.Item")
@Table (name = "item1")
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private long itemId;
	
	@Column(name = "quantity")
	private int qty;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}
