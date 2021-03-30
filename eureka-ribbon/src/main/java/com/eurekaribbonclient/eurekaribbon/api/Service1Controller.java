package com.eurekaribbonclient.eurekaribbon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private static final String HELLO_FROM_S_BR_RESPONSE_THROUGH_RIBBON_S_S =
            "Hello from %s,<br/> Response through ribbon%s: %s";
    private static final String EMPTY_STRING = "";
    private static final String HTTP_LOCALHOST_9091 = "http://localhost:9091/";
    private static final String EUREKA_RIBBON_CLIENT_2 = "eureka_ribbon_client_2";
    private static final String HTTP_S_S = "http://%s:%s";
    private static final String LOAD_BALANCED = "(load-balanced)";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Value(" ${spring.application.name}")
    private String appName;

    @GetMapping
    public String welcome() {
        return String.format(HELLO_FROM_S_BR_RESPONSE_THROUGH_RIBBON_S_S,
                appName, EMPTY_STRING, restTemplate.getForObject(HTTP_LOCALHOST_9091, String.class));
    }

    @GetMapping("/load-balancer")
    public String welcomeWithLoadBalancer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(EUREKA_RIBBON_CLIENT_2);
        URI uri = URI.create(String.format(HTTP_S_S, serviceInstance.getHost(), serviceInstance.getPort()));
        return String.format(HELLO_FROM_S_BR_RESPONSE_THROUGH_RIBBON_S_S,
                appName, LOAD_BALANCED, restTemplate.getForObject(uri, String.class));
    }
}
