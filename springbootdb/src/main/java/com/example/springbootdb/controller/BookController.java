package com.example.springbootdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootdb.entity.Book;
import com.example.springbootdb.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 検索画面表示
    @GetMapping("/search")
    public String searchBooks(@RequestParam(value = "bookTitle", required = false) String bookTitle, Model model) {
        if (bookTitle != null && !bookTitle.isEmpty()) {
            List<Book> books = bookService.searchBooksByTitle(bookTitle);
            model.addAttribute("books", books);
        }
        return "book/search"; // 検索結果を表示するビュー
    }

    // 登録画面表示（必要であれば）
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";  // 本の登録画面ビュー
    }

    // 本の登録
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        // 登録後、検索画面にリダイレクトし、成功メッセージを表示
        return "redirect:/books/search?success=true";
    }
}
