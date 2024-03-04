package com.spring.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.BookService;
import com.spring.boot.models.Book;

@RestController
public class MainController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> allBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book singleBook(@PathVariable("id") int id) {
		return bookService.getBook(id);
	}
}
