package com.example.restapi.api;

import com.example.restapi.entities.Car;
import com.example.restapi.services.CarService;
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

    private CarService carService;

    @Value("${app.id}")
    private String instance;

    @Autowired
    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String hi() {
        return "Welcome, I am " + instance;
    }

    @GetMapping("/cars/{userName}")
    public List<Car> getCarsById(@PathVariable String carName) {
        return carService.getCarsByName(carName);
    }

    @GetMapping("/cars/random")
    public Car getRandomCar() {
        return carService.getRandomUser();
    }
}
