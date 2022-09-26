package com.com.thai.dang.domain.student;

public class StudentDomain {

	private int pkIdStudent;
	private String firstName;
	private String lastName;

	public StudentDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDomain(int pkIdStudent, String firstName, String lastName) {
		super();
		this.pkIdStudent = pkIdStudent;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getPkIdStudent() {
		return pkIdStudent;
	}

	public void setPkIdStudent(int pkIdStudent) {
		this.pkIdStudent = pkIdStudent;
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
