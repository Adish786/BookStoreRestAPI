package com.bookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.services.IBookStoreService;

@RestController
public class BookStoreController {
	
	@Autowired
	private IBookStoreService service;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		
		List<Book> books = service.getBooks();
		return books;
		
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") Integer id){
		Book book = service.getBook(id);
		return book;
	}
	
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book){
		Book b = service.createBook(book);
		return b;
		
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") int id, @RequestBody Book book){
		
		Book b = service.updateBook(id, book);
		return b;
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id") int id){
		boolean isDeleted = service.deleteBook(id);
		if(isDeleted){
			String responseContent = "Book has been deleted successfully";
			return responseContent;
		}
		String error = "Error while deleting book from database";
		return error;
	}

}
