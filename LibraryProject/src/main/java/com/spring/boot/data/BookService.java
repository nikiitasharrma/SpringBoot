package com.spring.boot.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.spring.boot.models.Book;

@Component
public class BookService {
	
	private static List<Book> books = new ArrayList<>();
	
	static {
		books.add(new Book(1, "Theory of Relativity", "Albert Einstein"));
		books.add(new Book(2, "Pride & Prejudice", "Jane Austen"));
		books.add(new Book(3, "Diary of a wimpy kid", "Jeff Kinney"));
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	public Book getBook(int id) {
		Book book = null;
		try {
			book = books.stream().filter(bw->bw.getId() == id).findFirst().get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		books.add(book);
		return book;
	}
	
	public String deleteBook(int id) {
		books = books.stream().filter(b->b.getId()!=id).collect(Collectors.toList());
		return "The book with id " + id + " has been deleted";
	}
	
	public String updateBook(Book book, int bookId) {
		books.stream().map(e->{
				if(e.getId() == bookId) {
					e.setName(book.getName());
					e.setAuthor(book.getAuthor());
				}
				return e;
		      }).collect(Collectors.toList());
		return "The book with id " + bookId + " has been updated!";
	}
	
}
