package com.frys.mapping.ManyToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_address")
public class BillingAddress {
	
	public BillingAddress() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private long addressId;
	@Column( name = "city" )
	private String city;
	@Column (name = "state")
	private String state;
	@Column(name = "zip")
	private String zip;
	/*@ManyToMany
	Collection<Customer> customers = new ArrayList<Customer>();
	
	public Collection<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}*/
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
}
