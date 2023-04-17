package com.in28Minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name="user_details")	
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Size(min=2,message="min 2 characters should be entered")
	@Column(nullable = false)
	private String Name;
	
	@Past(message="BirthDate Cannot be in future")
    @Column(nullable = false)
	private LocalDate date;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public User() {
		super();
	}

	public User(Integer id, String name, LocalDate date) {
		super();
		Id = id;
		Name = name;	
		this.date = date;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", date=" + date + "]";
	}

	

}
