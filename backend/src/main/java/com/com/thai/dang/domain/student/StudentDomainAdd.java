package com.com.thai.dang.domain.student;

public class StudentDomainAdd {

	private String firstName;
	private String lastName;

	public StudentDomainAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDomainAdd(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
