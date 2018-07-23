package com.frys.mapping.OneToOne.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  (name = "com.frys.mapping.OneToOne.unidirectional.Student")
@Table(name = "student1")
public class Student {

	public Student() {
		//empty constructor
	}
	
	@Id
	@GeneratedValue
	@Column( name = "student_id" )
	private int studentId;
	
	@Column( name = "student_name" )
	private String studentName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
