package com.example.eurekazuulclient.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple endpoint
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 17:34
 */
@RestController
public class HomeController {

    @Value("${app.id}")
    private String instance;

    @GetMapping("/")
    public String hi() {
        return "Welcome, I am " + instance;
    }
}
