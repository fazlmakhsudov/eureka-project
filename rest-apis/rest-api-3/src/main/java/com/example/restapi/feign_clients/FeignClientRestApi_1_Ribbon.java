package com.example.restapi.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

/**
 * Feign client for ms 1
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:34
 */
@FeignClient(value = "eureka-ribbon-client-1", url = "http://localhost:5001")
public interface FeignClientRestApi_1_Ribbon {

    @GetMapping("/books/random")
    String client1RibbonResponse();
}
