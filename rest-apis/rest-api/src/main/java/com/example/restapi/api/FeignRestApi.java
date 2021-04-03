package com.example.restapi.api;

import com.example.restapi.feign_clients.FeignClientRestApi_3;
import com.example.restapi.feign_clients.FeignClientRestApi_4;
import com.example.restapi.feign_clients.FeignClientRestApi_5;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:32
 */
@RestController
public class FeignRestApi {

    @Value("${spring.application.name}:${server.port}")
    private String instance;

    @Autowired
    private FeignClientRestApi_3 feignClientRestApi3;

    @Autowired
    private FeignClientRestApi_4 client3responseForRestApi4;

    @Autowired
    private FeignClientRestApi_5 client3responseForRestApi5;

    @GetMapping("/users/random")
    public String askUser() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Rest api", instance);
        jsonObject.put("Response from rest-api-3", feignClientRestApi3.client3response());
        return jsonObject.toString();
    }

    @GetMapping("/cars/random")
    public String askCar() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Rest api", instance);
        jsonObject.put("Response from rest-api-4", client3responseForRestApi4.client4response());
        return jsonObject.toString();
    }

    @GetMapping("/brands/random")
    public String askBrand() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Rest api", instance);
        jsonObject.put("Response from rest-api-5", client3responseForRestApi5.client5response());
        return jsonObject.toString();
    }
}
