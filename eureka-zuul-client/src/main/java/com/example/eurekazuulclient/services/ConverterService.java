package com.example.eurekazuulclient.services;

import com.example.eurekazuulclient.dto.BookDto;
import com.example.eurekazuulclient.entities.Book;
import org.springframework.stereotype.Service;

/**
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:20
 */
@Service
public class ConverterService {

    public Book convertToBook(BookDto bookDto) {
        return new Book(bookDto.getName());
    }

    public BookDto convertToBookDto(Book book) {
        return new BookDto(book.getId(), book.getName());
    }
}
