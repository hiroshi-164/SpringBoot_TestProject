package com.example.springbootdb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootdb.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // bookTitleに部分一致する本を検索
    List<Book> findByBookTitleContaining(String bookTitle);
}