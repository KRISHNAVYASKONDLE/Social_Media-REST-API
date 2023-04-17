package com.in28Minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource ms;
	
	
	
	public HelloWorldController(MessageSource ms) {
		super();
		this.ms = ms;
	}
	
	

	@GetMapping(path ="/hello-world" )
	public String helloWorld()
	{
		return "Hello-World";
	}
	
	@GetMapping(path ="/hello-world-bean" )
	public HelloworldBean helloWorldbean()
	{
		return new HelloworldBean("hello from bean");
	}

	@GetMapping(path ="/hello-world-internationalization" )
	public String helloWorldinternationalization()
	{
		Locale lc=LocaleContextHolder.getLocale();
		return ms.getMessage("good.morning.message", null, "Default Message", lc); 
		
//		return ("hello from bean");
	}
	
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloworldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloworldBean(String.format("HelloWorld, %s",name ));
	}
	
	
	
	

}