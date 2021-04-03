package com.example.restapi.api;

import com.example.restapi.entities.Brand;
import com.example.restapi.services.BrandService;
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

    private BrandService brandService;

    @Value("${app.id}")
    private String instance;

    @Autowired
    public HomeController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/")
    public String hi() {
        return "Welcome, I am " + instance;
    }

    @GetMapping("/brands/{userName}")
    public List<Brand> getCarsById(@PathVariable String carName) {
        return brandService.getBrandsByName(carName);
    }

    @GetMapping("/brands/random")
    public Brand getRandomCar() {
        return brandService.getRandomBrand();
    }
}
