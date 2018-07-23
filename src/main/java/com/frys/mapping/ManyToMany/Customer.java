package com.frys.mapping.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private long custId;
	@Column(name = "customer_name")
	private String custName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address", joinColumns =  {@JoinColumn (name = "customer_id")}, inverseJoinColumns = {@JoinColumn (name = "address_id")})
	Collection<BillingAddress> addresses = new ArrayList<BillingAddress>();
	
	public Collection<BillingAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<BillingAddress> addresses) {
		this.addresses = addresses;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
}
