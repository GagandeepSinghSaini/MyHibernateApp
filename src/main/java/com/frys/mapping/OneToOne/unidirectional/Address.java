package com.frys.mapping.OneToOne.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "com.frys.mapping.OneToOne.unidirectional.Address")
@Table( name="address1" )
public class Address {

	public Address() {
		// empty Address
	}
	
	@Id
	@GeneratedValue
	@Column( name="address_id" )
	private long addressId;
	@Column( name="city" )
	private String city;
	@Column( name="state" )
	private String state;
	
	
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
	
	
	
}
