package com.in28Minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


//@Component
public class UserService {

	public static List<User> li=new ArrayList<>();
	
	
	public static int id;
//	static {
//		li.add(new User(++id, "Krishna1", LocalDate.now().minusMonths(5)));
//		li.add(new User(++id, "Krishna2", LocalDate.now().minusMonths(4)));
//		li.add(new User(++id, "Krishna3", LocalDate.now().minusMonths(3)));
//		li.add(new User(++id, "Krishna4", LocalDate.now().minusMonths(2)));
//		li.add(new User(++id, "Krishna5", LocalDate.now().minusMonths(1)));
//	}

	public List<User> findAll()
	{
		return li;
	}


	public User findUser(int id)
	{
		Predicate<? super User> predicate= us -> us.getId().equals(id);
		return li.stream().filter(predicate).findFirst().orElse(null);
	}


	public User save(User user) {
		// TODO Auto-generated method stub
		user.setId(++id);
		li.add(user);
		return user;
	}


	public String deleteUser(int id2) {
		// TODO Auto-generated method stub
		
		Predicate<? super User> pr=us-> us.getId().equals(id2);
		User us=li.stream().filter(pr).findFirst().orElse(null);
		
		if(us ==null)
		{
			throw new UserNotFoundException("No User found with id ::"+id2);
		}
		li.removeIf(pr);		
		return "sucessfully deleted";
	}


}
