package com.example.restapi.repositories;

import com.example.restapi.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Book repository
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 22:07
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);

}
