package com.library.library.author;

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
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
//	New author
	@PostMapping("/authors")
	public String saveAuthor(@RequestBody Author author) {
		authorService.saveAuthor(author);
		return "New author created";
	}
	
//	Get authors
	@GetMapping("/authors")
	public List<Author> findAllAuthors(){
		return authorService.findAllAuthors();
	}
	
//	Get single author
	@GetMapping("/authors/{id}")
	public Author findSingleAuthor(@PathVariable long id) {
		return authorService.findAuthorById(id);
	}
	
	@PutMapping("/authors/{id}")
	public Author updateAuthor(@PathVariable long id, @RequestBody Author author) {
		return authorService.updateAuthor(id, author);
	}
	
//	Delete author
	@DeleteMapping("/authors/{id}")
	public String deleteAuthor(@PathVariable long id) {
		return authorService.deleteAuthor(id);
	}

}
