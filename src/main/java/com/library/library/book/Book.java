package com.library.library.book;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.library.library.Auditable;
import com.library.library.author.Author;

@Entity
@Table(name="book")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="book_id")
public class Book extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long book_id;
	private String book_name;
	private String book_description;
	
	@ManyToOne
	@JoinColumn(name="author_id", insertable=false, updatable=false)
	private Author author;
	private Integer author_id;
	
	
	@CreatedDate
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime modified_at;
	
	public Book() {

	}

	public Book(Long book_id, String book_name, String book_description, Integer author_id,
			LocalDateTime created_at, LocalDateTime modified_at) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_description = book_description;
		this.author_id = author_id;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
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

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_description=" + book_description
				+ ", author_id=" + author_id + "]";
	}
	
}
