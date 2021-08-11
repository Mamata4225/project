package com.xworkz.enroll.dto;

public class StudentEnrollDTO {

	private String enrollName;
	
	private String email;

	
	public StudentEnrollDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEnrollDTO(String enrollName, String email) {
		super();
		this.enrollName = enrollName;
		this.email = email;
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
		return "StudentEnrollDTO [enrollName=" + enrollName + ", email=" + email + "]";
	}

}
