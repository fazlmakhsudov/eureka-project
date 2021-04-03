package com.eurekaribbonclient.eurekaribbon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Rest controller with Ribbon
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 30.03.21 21:04
 */
@RestController
public class Service1Controller {

    private static final String REST_API_1 = "rest-api-1";

    private static final String HTTP_S_S = "http://%s:%s%s";

    private static final String BOOKS_RANDOM = "/books/random";

    private static final String USERS_RANDOM = "/users/random";

    private static final String CARS_RANDOM = "/cars/random";

    private static final String BRANDS_RANDOM = "/brands/random";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping
    public String welcome() {
        return "Hello from Ribbon for rest api 1";
    }

    @GetMapping("/books/random")
    public String forwardGetBookRandom() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(REST_API_1);
        URI uri = URI.create(String.format(HTTP_S_S, serviceInstance.getHost(), serviceInstance.getPort(),
                BOOKS_RANDOM));
        return String.format("Forwarding to %s,<br/>response <====== %s", uri.toString(),
                restTemplate.getForObject(uri, String.class));
    }

    @GetMapping("/users/random")
    public String forwardGetUserRandom() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(REST_API_1);
        URI uri = URI.create(String.format(HTTP_S_S, serviceInstance.getHost(), serviceInstance.getPort(),
                USERS_RANDOM));
        return String.format("Forwarding to %s,<br/>response <====== %s", uri.toString(),
                restTemplate.getForObject(uri, String.class));
    }

    @GetMapping("/cars/random")
    public String forwardGetCarRandom() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(REST_API_1);
        URI uri = URI.create(String.format(HTTP_S_S, serviceInstance.getHost(), serviceInstance.getPort(),
                CARS_RANDOM));
        return String.format("Forwarding to %s,<br/>response <====== %s", uri.toString(),
                restTemplate.getForObject(uri, String.class));
    }

    @GetMapping("/brands/random")
    public String forwardGetBrandRandom() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(REST_API_1);
        URI uri = URI.create(String.format(HTTP_S_S, serviceInstance.getHost(), serviceInstance.getPort(),
                BRANDS_RANDOM));
        return String.format("Forwarding to %s,<br/>response <====== %s", uri.toString(),
                restTemplate.getForObject(uri, String.class));
    }
}
