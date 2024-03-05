package com.spring.boot.data;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
