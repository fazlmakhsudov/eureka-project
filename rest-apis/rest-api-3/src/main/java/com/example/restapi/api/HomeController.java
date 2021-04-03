package com.example.restapi.api;

import com.example.restapi.entities.User;
import com.example.restapi.services.UserService;
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

    private UserService userService;

    @Value("${app.id}")
    private String instance;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hi() {
        return "Welcome, I am " + instance;
    }

    @GetMapping("/users/{userName}")
    public List<User> getUserById(@PathVariable String userName) {
        return userService.getUsersByName(userName);
    }

    @GetMapping("/users/random")
    public User getRandomUser() {
        return userService.getRandomUser();
    }
}
