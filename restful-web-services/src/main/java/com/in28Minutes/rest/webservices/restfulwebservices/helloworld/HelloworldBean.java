package com.in28Minutes.rest.webservices.restfulwebservices.helloworld;



public class HelloworldBean {

	private String str="";

	public HelloworldBean(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "HelloworldBean [str=" + str + "]";
	}
	
	
	
}
