package com.tutorial.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
@JsonIgnoreProperties("id")
public class User {


	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Size(min=2, message="name should have at least 2 characteres")
	@JsonProperty("user_name")
	private String name;
	
	@NotNull
	@Past(message="Birth Date should be in the past")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	@NotNull
	@Size(min=2, message="name should have at least 2 characteres")
	@JsonIgnore
	@JsonProperty("password")
	private String password;
	
	public User(Integer id, String name, LocalDate birthDate, String password) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
