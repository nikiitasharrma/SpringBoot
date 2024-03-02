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
		
		User user1 = new User("Archit", "HighGarden");
		User user2 = new User("Ben", "Bombay");
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
		
		/**
		 * custom finder methods
		 */
		//findByName
		List<User> nameResult = userRepo.findByName("Archit");
		nameResult.forEach(name->System.out.println(name));
		
		//data support keywords
		//findByNameAndCity
		List<User> andResult = userRepo.findByNameAndCity("Archit", "Mumbai");
		andResult.forEach(andUser->System.out.println(andUser));
		
		//findByNameStartingWith
		List<User> nameStartingC = userRepo.findByNameStartingWith("C");
		nameStartingC.forEach(c->System.out.println(c));
		
		//findByCityEndingWith
		List<User> cityEndingY = userRepo.findByCityEndingWith("y");
		cityEndingY.forEach(y->System.out.println(y));
		
		//findByNameContaining
		List<User> containingResult = userRepo.findByNameContaining("en");
		containingResult.forEach(en->System.out.println(en));
		
		//findByCityLike
		List<User> cityPattern = userRepo.findByCityLike("%gh%");
		cityPattern.forEach(p->System.out.println(p));
		
		//findByIdLessThan
		List<User> idLessThan = userRepo.findByIdLessThan(100);
		idLessThan.forEach(less->System.out.println(less));
		
		//findByIdGreaterThanEqual
		List<User> idGreaterThan = userRepo.findByIdGreaterThanEqual(100);
		idGreaterThan.forEach(greater->System.out.println(greater));
		
		//findByIdIn
		List<Integer> ids = List.of(102, 204, 304);
		List<User> idIn = userRepo.findByIdIn(ids);
		idIn.forEach(id->System.out.println(id));
		
		//findByCityOrderByName
		List<User> cityNameResult = userRepo.findByCityOrderByName("HighGarden");
		cityNameResult.forEach(h->System.out.println(h));
		
		/*
		 * JPQL methods
		 */
		userRepo.getAllUsers().forEach(all->System.out.println(all));
		userRepo.getNameUser("Archit").forEach(ar->System.out.println(ar));
		
		/**
		 * Native SQL query methods 
		 */
		userRepo.getUsersNative().forEach(nat->System.out.println(nat));
		
	}

}
