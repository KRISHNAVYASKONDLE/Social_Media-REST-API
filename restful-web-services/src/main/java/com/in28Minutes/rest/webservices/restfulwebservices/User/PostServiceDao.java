package com.in28Minutes.rest.webservices.restfulwebservices.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.validation.Valid;

@Repository 
public class PostServiceDao {

	public PostRepository postRepository;

	public PostServiceDao(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	

	public Post save( Post post) {
		// TODO Auto-generated method stub
		postRepository.save(post);
		return post;
	}
	
		
	
}
