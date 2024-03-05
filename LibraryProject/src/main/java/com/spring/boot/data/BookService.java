package com.spring.boot.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.models.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks(){
		return (List<Book>) bookRepo.findAll();
	}
	
	public Book getBook(int id) {
		Book book = null;
		try {
			book = bookRepo.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		bookRepo.save(book);
		return book;
	}
	
	public String deleteBook(int id) {
		bookRepo.deleteById(id);
		return "The book with id " + id + " has been deleted";
	}
	
	public String updateBook(Book book, int bookId) {
		
		book.setId(bookId);
		bookRepo.save(book);
		
		return "The book with id " + bookId + " has been updated!";
	}
	
}
