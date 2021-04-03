package com.example.restapi.repositories;

import com.example.restapi.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Car repository
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 22:07
 */
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByName(String name);

}
