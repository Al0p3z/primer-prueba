package com.tutorial.rest.webservices.restful_web_services.jpa.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutorial.rest.webservices.restful_web_services.jpa.user.UserJpa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name="post")
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Size(min=2, message="name should have at least 2 characteres")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserJpa user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserJpa getUser() {
		return user;
	}

	public void setUser(UserJpa user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
}
