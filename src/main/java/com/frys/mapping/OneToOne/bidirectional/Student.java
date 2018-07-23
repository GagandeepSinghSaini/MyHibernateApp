package com.frys.mapping.OneToOne.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name = "com.frys.mapping.OneToOne.bidirectional.Student")
@Table (name = "student2")
public class Student {

	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
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
