package com.api.rest.book.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.book.dao.BookRepository;
import com.api.rest.book.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// get All Book-readAll
	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get Book by id-read single
	public Book getBookById(int id) {
		Book book = null;
		try {
			this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Create-add
	public Book addBook(Book book) {
		Book result = this.bookRepository.save(book);
		return result;
	}

	// delete
	public void deleteBook(int id) {
		this.bookRepository.deleteById(id);
	}
	// update

	public void updateBook(Book book, int id) {
		book.setId(id);
		this.bookRepository.save(book);

	}

}
