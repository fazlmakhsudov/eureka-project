package com.example.restapi.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign client for ms 1
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:34
 */
@FeignClient(value = "rest-api-5", url = "http://localhost:4005")
public interface FeignClientRestApi_5 {

    @GetMapping("/brands/random")
    String client5Response();
}
