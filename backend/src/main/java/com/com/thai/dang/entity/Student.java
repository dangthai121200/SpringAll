package com.com.thai.dang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.com.thai.dang.event.StudentEvent;

@Entity
@Table(name = "student")
@EntityListeners(StudentEvent.class)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_STUDENT")
	private int pkIdStudent;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FULL_NAME")
	private String fullName;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
