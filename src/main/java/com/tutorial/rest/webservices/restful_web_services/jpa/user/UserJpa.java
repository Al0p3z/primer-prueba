package com.tutorial.rest.webservices.restful_web_services.jpa.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tutorial.rest.webservices.restful_web_services.jpa.post.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_jpa_details")
public class UserJpa {
	
	protected UserJpa() {
		
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Size(min=2, message="name should have at least 2 characteres")
	@JsonProperty("user_name")
	private String userName;
	
	@NotNull
	@Past(message="Birth Date should be in the past")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	@NotNull
	@Size(min=2, message="name should have at least 2 characteres")
	@JsonProperty("password")
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	public UserJpa(Integer id, String userName, LocalDate birthDate, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthDate = birthDate;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
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
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserJpa [id=" + id + ", name=" + userName + ", birthDate=" + birthDate + "]";
	}
}
