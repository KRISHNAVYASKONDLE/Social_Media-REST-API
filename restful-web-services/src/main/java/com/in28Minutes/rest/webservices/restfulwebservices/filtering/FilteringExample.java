package com.in28Minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringExample {

	
	@GetMapping(path="/filter")
	public MappingJacksonValue staticFiltering()
	{
		SomeBean someBean = new SomeBean("first","second","third");
		MappingJacksonValue mjv=new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter spf=SimpleBeanPropertyFilter.filterOutAllExcept("Third");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanFilter", spf);
	    mjv.setFilters(filters);
	    return mjv;
		
	}
	
	@GetMapping(path="/filter-list")
	public MappingJacksonValue staticFilteringList()
	{
		List<SomeBean> list = Arrays.asList(new SomeBean("first","second","third"), new SomeBean("first","second","third"));

		MappingJacksonValue mjvlist=new MappingJacksonValue(list);
		SimpleBeanPropertyFilter spflist=SimpleBeanPropertyFilter.filterOutAllExcept("second","Third");
		FilterProvider filterlist=new SimpleFilterProvider().addFilter("someBeanFilter", spflist);
		mjvlist.setFilters(filterlist);
		return mjvlist;
	}	
	
	
}
