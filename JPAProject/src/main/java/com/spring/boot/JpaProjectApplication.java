package com.spring.boot;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.boot.models.User;
import com.spring.boot.repository.UserRepository;

@SpringBootApplication
public class JpaProjectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(JpaProjectApplication.class, args);
		
		UserRepository userRepo = context.getBean(UserRepository.class);
		
		User user1 = new User("Archit", "Mumbai");
		User user2 = new User("Ben", "HighGarden");
		User user3 = new User("Catherine", "New York");
		
		//Create single user
		User user = userRepo.save(user1);
		System.out.println(user);
		
		//create all users together
		List<User> userList = List.of(user1, user2, user3);
		Iterable<User> result = userRepo.saveAll(userList);
		result.forEach(u->{System.out.println(u);});
		
		//update a user
		//get a user by id
		Optional<User> optional = userRepo.findById(2);
		
		User toBeUpdated = optional.get();
		toBeUpdated.setCity("Jamshedpur");
		User updatedUser = userRepo.save(toBeUpdated);
		System.out.println(updatedUser);
		
		//get all users
		Iterable<User> allUsers = userRepo.findAll();
		allUsers.forEach(usr->{System.out.println(usr);});
		
		//delete a user
		userRepo.delete(user2);
		
	}

}
