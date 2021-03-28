package com.mightyjava.eurekaclient;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

    @Value("${spring.application.name}")
    private String appName;

    private static final String HTTP_LOCALHOST_8001_TIME = "http://localhost:8001/time";

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World! " + appName;
    }

    @GetMapping("/ask-time")
    public String askWhatTime() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(String.format("ask time from %s", appName), restTemplate.exchange(HTTP_LOCALHOST_8001_TIME,
                HttpMethod.GET, null, String.class).getBody());
        return jsonObject.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
