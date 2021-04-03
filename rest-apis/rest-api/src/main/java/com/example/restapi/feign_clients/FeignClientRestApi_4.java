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
@FeignClient(value = "rest-api-4", url = "http://localhost:4004")
public interface FeignClientRestApi_4 {

    @GetMapping("/cars/random")
    String client4response();
}
