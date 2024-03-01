package com.spring.boot;

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
		
		User user = new User();
		user.setName("Raghav");
		user.setCity("Jaipur");
		userRepo.save(user);
		
		System.out.println(userRepo.findById(1));
	}

}
