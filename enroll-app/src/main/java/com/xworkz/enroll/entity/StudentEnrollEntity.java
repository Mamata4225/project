package com.xworkz.enroll.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enroll_table")
public class StudentEnrollEntity implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENROLL_ID")
	private int enrollID;
	
	@Column(name = "ENROLL_NAME")
	private String enrollName;

	@Column(name = "ENROLL_EMAIL")
	private String email;

	public StudentEnrollEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEnrollID() {
		return enrollID;
	}

	public void setEnrollID(int enrollID) {
		this.enrollID = enrollID;
	}

	public String getEnrollName() {
		return enrollName;
	}

	public void setEnrollName(String enrollName) {
		this.enrollName = enrollName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentEnrollEntity [enrollID=" + enrollID + ", enrollName=" + enrollName + ", email=" + email + "]";
	}
	
	
	
	
}
