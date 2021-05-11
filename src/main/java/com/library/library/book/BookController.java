package com.library.library.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
//	New book
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
//	Get books
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return bookService.findAllBooks();
	}
	
//	Get single book
	@GetMapping("/books/{id}")
	public Book findSingleBook(@PathVariable long id) {
		return bookService.findBookById(id);
	}
	
//	Update book
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable long id) {
		return bookService.updateBook(book, id);
	}
	
//	Delete book
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable long id) {
		return bookService.deleteBook(id);
	}
}
