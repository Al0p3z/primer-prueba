package com.tutorial.rest.webservices.restful_web_services.user;


public class GenericResponseDetails {

	private String message;
	private String details;

	public GenericResponseDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	

}