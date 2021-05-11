package com.library.library.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
//	Save new Author
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}
	
//	Get all authors
	public List<Author> findAllAuthors(){
		return authorRepository.findAll();
	}
	
//	Get author by id
	public Author findAuthorById(long id) {
		return authorRepository.findById(id).get();
	}
	
//	Update author
	public Author updateAuthor(long id, Author author) {
//		Author updateAuthor = findAuthorById(id);
//		updateAuthor.setFirst_name(author.getFirst_name());;
//		updateAuthor.setLast_name(author.getLast_name());
//		return authorRepository.save(updateAuthor);
		 return authorRepository.findById(id)
				 .map(newAuthor -> {
					 newAuthor.setFirst_name(author.getFirst_name());
					 newAuthor.setLast_name(author.getLast_name());
			        return authorRepository.save(newAuthor);
			      })
			      .orElseGet(() -> {
			    	  author.setAuthor_id(id);
			    	  return authorRepository.save(author);
			      });
	}
	
//	Delete author by id
	public String deleteAuthor(long id) {
		authorRepository.deleteById(id);
		return "Author successfully deleted";
	}

}
