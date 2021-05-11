package com.library.library.author;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.library.library.Auditable;
import com.library.library.book.Book;

@Entity
@Table(name="author")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="author_id")
public class Author extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long author_id;
	private String first_name;
	private String last_name;
	
	@CreatedDate
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime modified_at;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
	private List<Book> books;
	
	public Author() {
	}

	public Author(Long author_id, String first_name, String last_name, LocalDateTime created_at,
			LocalDateTime modified_at, List<Book> books) {
		this.author_id = author_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.books = books;
	}

	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(LocalDateTime modified_at) {
		this.modified_at = modified_at;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", created_at=" + created_at + ", modified_at=" + modified_at + ", books=" + books + "]";
	}
}
