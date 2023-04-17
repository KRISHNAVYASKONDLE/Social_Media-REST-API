package com.in28Minutes.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class UserResource {

	public UserServiceDao userService;


	public UserResource(UserServiceDao userService) {
		super();
		this.userService = userService;
	}



	@GetMapping(path="/users")
	public List<User> Allusers()
	{
		
		return userService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public EntityModel<Optional<User>> Allusers(@PathVariable int id)
	{	
		Optional<User> particularUser=userService.findUser(id);
		if(particularUser == null)
		{
			throw new UserNotFoundException("id::"+id);
		}	
		
		EntityModel<Optional<User>> em=EntityModel.of(particularUser);
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).Allusers());
				
		em.add(link.withRel("All_Users"));
		
		return em;
		
	}
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> postsOfUser(@PathVariable int id)
	{	
		Optional<User> particularUser=userService.findUser(id);
					
		if(particularUser == null)
		{
			throw new UserNotFoundException("id::"+id);
		}	
		return particularUser.get().getPost();

	}
	
	@GetMapping(path="/users/{id}/posts/{p_id}")
	public Post postOfUser(@PathVariable int id,@PathVariable int p_id)
	{	
		Optional<User> particularUser=userService.findUser(id);
					
		if(particularUser == null)
		{
			throw new UserNotFoundException("id::"+id);
		}	
		
		return userService.findSpecificuserPost(id, p_id);

	}

	
	@DeleteMapping(path="/users/{id}")
	public void DeleteUsers(@PathVariable int id)
	{	
		userService.deleteUser(id);		
	}


	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		
		User savedUser=userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable int id,@Valid @RequestBody Post post)
	{
		
		
		Optional<User> particularUser=userService.findUser(id);
		if(particularUser == null)
		{
			throw new UserNotFoundException("id::"+id);
		}	
		post.setUser(particularUser.get());
		
		Post savedPost=userService.savePost(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
		
//		EntityModel<Post> em=EntityModel.of(savedPost);
//		
//		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).postsOfUser(id));
//		em.add(link.withRel("User_Posts"));
		return ResponseEntity.created(location).build();
	}

	
		
	
}
