package com.spring.boot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.boot.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// custom Finder Methods
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

	// JPQL
	@Query("SELECT u FROM User u")
	public List<User> getAllUsers();

	@Query("SELECT u FROM User u WHERE u.name= :n")
	public List<User> getNameUser(@Param("n") String name);

	// Native SQL query
	@Query(value = "SELECT * FROM User", nativeQuery = true)
	public List<User> getUsersNative();

}
