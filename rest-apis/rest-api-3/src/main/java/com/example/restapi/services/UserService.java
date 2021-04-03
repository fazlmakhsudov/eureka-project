package com.example.restapi.services;

import com.example.restapi.entities.User;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * User service
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 22:15
 */
@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getRandomUser() {
        return repository.findById((long) (new Random().nextInt(8))).orElse(new User("Absent user"));
    }

    public List<User> getUsersByName(String name) {
        if (name != null && name.length() > 1) {
            name = name.toLowerCase();
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            return repository.findByName(name);
        } else {
            throw new IllegalArgumentException("Wrong name. Type correct name more than 1 symbol.");
        }
    }
}
