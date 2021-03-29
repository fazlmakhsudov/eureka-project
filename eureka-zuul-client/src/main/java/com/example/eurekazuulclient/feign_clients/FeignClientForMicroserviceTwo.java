package com.example.eurekazuulclient.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign clien for microservice two
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 20:21
 */
@FeignClient(value = "eureka-client-2", url = "http://localhost:8002/")
public interface FeignClientForMicroserviceTwo {

    @GetMapping
    String client3Response();

}
