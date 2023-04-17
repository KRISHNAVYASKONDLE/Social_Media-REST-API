package com.in28Minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties("first")
@JsonFilter("someBeanFilter")	
public class SomeBean {

	public String first;
	
//	@JsonIgnore
	public String second;
	
	@JsonProperty("Third")
	public String third;
	
	@Override
	public String toString() {
		return "SomeBean [first=" + first + ", second=" + second + ", third=" + third + "]";
	}
	public SomeBean(String first, String second, String third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getThird() {
		return third;
	}
	public void setThird(String third) {
		this.third = third;
	}	
	
	
	
	
}
