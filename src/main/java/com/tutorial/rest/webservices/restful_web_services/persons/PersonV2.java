package com.tutorial.rest.webservices.restful_web_services.persons;

public class PersonV2 {
	private String firstName;
	private String lastName;

	public PersonV2(String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
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
