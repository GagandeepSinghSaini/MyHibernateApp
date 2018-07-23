package com.frys.mapping.OneToOne.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name = "com.frys.mapping.OneToOne.bidirectional.Address")
@Table ( name = "address2" )
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "adress_id")
	private long addressId;
	@Column (name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@OneToOne
	@JoinColumn(name = "link_student_id")
	private Student student;
	
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
