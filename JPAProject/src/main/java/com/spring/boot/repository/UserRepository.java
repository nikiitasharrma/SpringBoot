package com.spring.boot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name, String city);
	
	public List<User> findByNameStartingWith(String prefix);
	
	public List<User> findByCityEndingWith(String suffix);
	
	public List<User> findByNameContaining(String words);
	
	public List<User> findByCityLike(String pattern);
	
	public List<User> findByIdLessThan(int i);
	
	public List<User> findByIdGreaterThanEqual(int i);
	
	public List<User> findByIdIn(Collection<Integer> ids);
	
	public List<User> findByCityOrderByName(String city);
	
}
