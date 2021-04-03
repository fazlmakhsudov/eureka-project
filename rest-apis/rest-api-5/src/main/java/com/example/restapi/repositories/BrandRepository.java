package com.example.restapi.repositories;

import com.example.restapi.entities.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Brand repository
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 27.03.21 22:07
 */
public interface BrandRepository extends CrudRepository<Brand, Long> {

    List<Brand> findByName(String name);

}
