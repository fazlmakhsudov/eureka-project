package com.example.eurekazuulclient.api;

import com.example.eurekazuulclient.dto.BookDto;
import com.example.eurekazuulclient.entities.Book;
import com.example.eurekazuulclient.services.BookService;
import com.example.eurekazuulclient.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple endpoint
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 17:34
 */
@RestController
public class HomeController {

    private final BookService bookService;

    private final ConverterService converterService;

    @Value("${app.id}")
    private String instance;

    @Autowired
    public HomeController(BookService bookService, ConverterService converterService) {
        this.bookService = bookService;
        this.converterService = converterService;
    }

    @GetMapping("/")
    public String hi() {
        return "Welcome, I am " + instance;
    }

    @GetMapping("/books/{bookName}")
    public List<BookDto> getBookById(@PathVariable String bookName) {
        return bookService.getBooksByName(bookName).stream().map(converterService::convertToBookDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/books")
    public BookDto getRandomBook() {
        return converterService.convertToBookDto(bookService.getRandomBook());
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestBody BookDto bookDto) {
        Book book = bookService.addBook(converterService.convertToBook(bookDto));
        return converterService.convertToBookDto(book).toString();
    }

    @PostMapping("/books/indirect")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@NotNull @RequestBody String bookName) {
        Book book = bookService.addBook(new Book(bookName));
        return converterService.convertToBookDto(book).toString();
    }
}
