package com.in28Minutes.rest.webservices.restfulwebservices.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	
	@Query(value = "SELECT * FROM post p WHERE p.id = ?2 and p.user_id=?1", nativeQuery = true)
		public Post findSpecificuserPost(Integer id,Integer user_id);

}
