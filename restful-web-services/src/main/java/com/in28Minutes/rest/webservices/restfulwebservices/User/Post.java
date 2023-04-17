package com.in28Minutes.rest.webservices.restfulwebservices.User;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity 
public class Post {

	@Id 
	@GeneratedValue
	private Integer Id;
	
	@Size(min=10)
	private String  description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore	
	private User user;

	public Post() {
		super();
	}

	@Override
	public String toString() {
		return "Post [Id=" + Id + ", description=" + description + ", user=" + user + "]";
	}



	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public 	String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post(Integer id, String description, User user) {
		super();
		Id = id;
		this.description = description;
		this.user = user;
	}
	
	
	
}
