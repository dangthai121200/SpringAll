package com.com.thai.dang.domain.student;

import jakarta.validation.constraints.NotEmpty;

public class StudentDomainAdd {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	public StudentDomainAdd(@NotEmpty String username, @NotEmpty String password, @NotEmpty String firstName,
			@NotEmpty String lastName) {
		super();
		this.username = username;
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class StudentDomainAddBuilde {

		private String username;
		private String password;
		private String firstName;
		private String lastName;

		public StudentDomainAddBuilde setUsername(String username) {
			this.username = username;
			return this;
		}

		public StudentDomainAddBuilde setPassword(String password) {
			this.password = password;
			return this;
		}

		public StudentDomainAddBuilde setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public StudentDomainAddBuilde setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public StudentDomainAdd builder() {
			return new StudentDomainAdd(username, password, firstName, lastName);
		}

	}

}
