package com.in28Minutes.rest.webservices.restfulwebservices.versioning;


public class Person2 {

	private Name name;

	public Person2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name + "]";
	}

 
	
	
	
	
}
