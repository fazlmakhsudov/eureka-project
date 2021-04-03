package com.example.restapi.api;

import com.example.restapi.feign_clients.FeignClientRestApi_1_Ribbon;
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

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private FeignClientRestApi_1_Ribbon feignClientRestApi_1_ribbon;

    @Autowired
    private FeignClientRestApi_4 feignClientRestApi4;

    @Autowired
    private FeignClientRestApi_5 feignClientRestApi5;

    @GetMapping("/books/random")
    public String askBook() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Rest api", appName);
        jsonObject.put("Response from rest-api-1(ribbon)<br/>",
                feignClientRestApi_1_ribbon.client1RibbonResponse());
        return jsonObject.toString();
    }

    @GetMapping("/cars/random")
    public String askCar() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Rest api", appName);
        jsonObject.put("Response from rest-api-4<br/>", feignClientRestApi4.client4Response());
        return jsonObject.toString();
    }

    @GetMapping("/brands/random")
    public String askBrand() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Rest api", appName);
        jsonObject.put("Response from rest-api-5<br/>", feignClientRestApi5.client5Response());
        return jsonObject.toString();
    }
}
