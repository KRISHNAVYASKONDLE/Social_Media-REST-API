package com.in28Minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;

public class ErrorDetails {

	private LocalDateTime time;
	private String message;
	private String Description;
	private List errlist;
	private Map<ObjectError, String> map;
	@Override
	public String toString() {
		return "ErrorDetails [time=" + time + ", message=" + message + ", Description=" + Description + "]";
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List getErrlist() {
		return errlist;
	}

	public void setErrlist(List errlist) {
		this.errlist = errlist;
	}

	public ErrorDetails(LocalDateTime time, Map<ObjectError, String> map, String description) {
		super();
		this.time = time;
		this.map = map;
		Description = description;
	}
	public ErrorDetails(LocalDateTime time, List errlist, String description) {
		super();
		this.time = time;
		this.errlist = errlist;
		Description = description;
	}

	public ErrorDetails(LocalDateTime now, String message2, String description2) {
	
		// TODO Auto-generated constructor stub
		this.time = now;
		this.message = message2;
		Description = description2;
	}

	public Map<ObjectError, String> getMap() {
		return map;
	}

	public void setMap(Map<ObjectError, String> map) {
		this.map = map;
	}

}
