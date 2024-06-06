package com.tutorial.rest.webservices.restful_web_services.persons;

public class PersonV1 {
	private String name;

	public PersonV1(String name) {
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
