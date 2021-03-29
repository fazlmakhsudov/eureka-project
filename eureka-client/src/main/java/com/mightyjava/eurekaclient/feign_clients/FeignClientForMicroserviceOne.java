package com.mightyjava.eurekaclient.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
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
@FeignClient(value = "eureka-client-1", url = "http://localhost:8000")
public interface FeignClientForMicroserviceOne {

    @PostMapping("/books/indirect")
    String client1response(@NotNull @RequestBody String bookName);
}
