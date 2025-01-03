package com.example.springbootdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdb.entity.Book;
import com.example.springbootdb.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// bookTitleに部分一致する本を検索
	public List<Book> searchBooksByTitle(String bookTitle) {
		return bookRepository.findByBookTitleContaining(bookTitle);
	}

	public void addBook(Book book) {
		bookRepository.save(book); // Bookエンティティを保存

	}
}