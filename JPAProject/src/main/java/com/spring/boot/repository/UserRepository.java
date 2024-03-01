package com.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
