package com.example.restapi.repositories;

import com.example.restapi.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User repository
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 22:07
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

}
