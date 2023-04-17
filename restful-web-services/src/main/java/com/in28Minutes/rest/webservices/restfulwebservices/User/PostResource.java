package com.in28Minutes.rest.webservices.restfulwebservices.User;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class PostResource {

	PostServiceDao postServiceDao;
	

	public PostResource(PostServiceDao postServiceDao) {
		super();
		this.postServiceDao = postServiceDao;
	}


	@PostMapping(path="/posts")
	public ResponseEntity<Post> createPost(@Valid @RequestBody Post post)
	{
		
		Post savedUser=postServiceDao.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
