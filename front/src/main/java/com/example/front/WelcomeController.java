package com.example.front;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

/**
 * Welcome Controller
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 04.04.21 14:45
 */
@Controller
public class WelcomeController {

    @GetMapping({"/", "/welcome"})
    public String welcomePage(@RequestParam(value = "name", defaultValue = "Fazliddin", required = true)
                              String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }

}
