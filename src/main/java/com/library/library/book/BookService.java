package com.library.library.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
//	Save new Book
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
//	Get all books
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	
//	Get book by id
	public Book findBookById(long id) {
		return bookRepository.findById(id).get();
	}
	
//	Update book
	public Book updateBook(Book book, long id) {
		Book updateBook = findBookById(id);
		updateBook.setAuthor_id(book.getAuthor_id());
		updateBook.setBook_name(book.getBook_name());
		updateBook.setBook_description(book.getBook_description());

		return bookRepository.save(updateBook);
	}
	
//	Delete book by id
	public String deleteBook(long id) {
		bookRepository.deleteById(id);
		return "A book has been deleted";
	}
	
}
