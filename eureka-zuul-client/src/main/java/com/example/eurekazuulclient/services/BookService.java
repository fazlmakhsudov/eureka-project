package com.example.eurekazuulclient.services;

import com.example.eurekazuulclient.entities.Book;
import com.example.eurekazuulclient.exceptions.EntityExistedException;
import com.example.eurekazuulclient.exceptions.Messages;
import com.example.eurekazuulclient.repositories.BookRepository;
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

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
        initializePrimary();
    }

    /**
     * Saves primary data
     */
    public void initializePrimary() {
        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));
        repository.save(new Book("C++"));
        repository.save(new Book("C#"));
        repository.save(new Book("SQL"));
        repository.save(new Book("GO"));
        repository.save(new Book("Ruby"));
    }

    public Book getRandomBook() {
        return repository.findById((long) (new Random().nextInt(8))).orElse(new Book("Absent book"));
    }

    public List<Book> getBooksByName(String name) {
        if (name != null && name.length() > 1) {
            name = makeFirstLetterUpper(name);
            return repository.findByName(name);
        } else {
            throw new IllegalArgumentException("Wrong name. Type correct name more than 1 symbol.");
        }
    }

    public Book addBook(Book book) {
        if (book.getName() != null && getBooksByName(book.getName()).size() == 0) {
            return repository.save(book);
        } else {
            throw new EntityExistedException(Messages.BOOK_ALREADY_EXISTS);
        }
    }

    private String makeFirstLetterUpper(String name) {
        name = name.toLowerCase();
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        return name;
    }
}
