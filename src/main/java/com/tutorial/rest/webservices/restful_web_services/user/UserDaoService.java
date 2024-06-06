package com.tutorial.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		users.add(new User (usersCount++, "Jose", LocalDate.now().minusYears(30), "123"));
		users.add(new User (usersCount++, "Teresa", LocalDate.now().minusYears(30), "123"));
		users.add(new User (usersCount++, "Andres", LocalDate.now().minusYears(20), "123"));
	}
	
	public List <User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User saveUser(User user) {
		user.setId(usersCount++);
		users.add(user);
		return user;
	}
	
	public boolean deleteUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.removeIf(predicate);
	}
}
