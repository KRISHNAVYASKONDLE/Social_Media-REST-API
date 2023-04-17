package com.in28Minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningExample {

	@GetMapping(path = "/v1/person")
	public Person1 uRIversioning1() {
		return new Person1("KrishnaVyas");
	}

	@GetMapping(path = "/v2/person")
	public Person2 uRIversioning2() {
		return new Person2(new Name("Krishna","vyas"));
	}

	@GetMapping(path="/person", params ="version=1" )
	public Person1 paramversioning1() {
		return new Person1("param");
	}
	
	@GetMapping(path="/person", params ="version=2" )
	public Person2 paramversioning2() {
		return new Person2(new Name("param","used"));
	}

	@GetMapping(path="/person", headers ="X-API-VERSION=1" )
	public Person1 headerversioning1() {
		return new Person1("header 1");
	}
	
	@GetMapping(path="/person", headers ="X-API-VERSION=2" )
	public Person2 headerversioning2() {
		return new Person2(new Name("header 2","used"));
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public Person1 getFirstVersionOfPersonAcceptHeader() {
		return new Person1("BobCharlie");
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public Person2 getSecondVersionOfPersonAcceptHeader() {
		return new Person2(new Name("Bob", "Charlie"));
	}
	
	
	
}
