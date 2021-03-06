package com.example.restapi.services;

import com.example.restapi.entities.Book;
import com.example.restapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Book service
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 22:15
 */
@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book getRandomBook() {
        return repository.findById((long) (new Random().nextInt(8))).orElse(new Book("Absent book"));
    }

    public List<Book> getBooksByName(String name) {
        if (name != null && name.length() > 1) {
            name = name.toLowerCase();
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            return repository.findByName(name);
        } else {
            throw new IllegalArgumentException("Wrong name. Type correct name more than 1 symbol.");
        }
    }
}
