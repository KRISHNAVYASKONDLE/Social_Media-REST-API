package com.in28Minutes.rest.webservices.restfulwebservices.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.validation.Valid;

@Repository 
public class UserServiceDao {

	public UserRepository userRepository;

	public PostRepository postRepository;
	
	public UserServiceDao(UserRepository userRepository, PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	public Optional<User> findUser(int id)
	{
		return userRepository.findById(id);
	}
	
	public User save(User user)
	{
		userRepository.save(user);
		return user;
	}
	
	public void deleteUser(int id)
	{
		userRepository.deleteById(id);
		
	}


	public Post savePost(@Valid Post post) {
		// TODO Auto-generated method stub
		 return postRepository.save(post);
	}
	
	public Post findSpecificuserPost(Integer id,Integer user_id)
	{
		return postRepository.findSpecificuserPost(id, user_id);
	}


	
	
	
}
