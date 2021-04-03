package com.example.restapi.api;

import com.example.restapi.entities.Book;
import com.example.restapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Simple endpoint
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 17:34
 */
@RestController
public class HomeController {

    private BookService bookService;

    @Value("${spring.application.name}:${server.port}")
    private String instance;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String hi() {
        return "Welcome, I am " + instance;
    }

    @GetMapping("/books/{bookName}")
    public List<Book> getBookById(@PathVariable String bookName) {
        return bookService.getBooksByName(bookName);
    }

    @GetMapping("/books/random")
    public Book getRandomBook() {
        return bookService.getRandomBook();
    }
}
