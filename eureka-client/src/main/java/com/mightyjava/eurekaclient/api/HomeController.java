package com.mightyjava.eurekaclient.api;

import com.mightyjava.eurekaclient.feign_clients.FeignClientForMicroserviceOne;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Rest controller
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:32
 */
@RestController
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    private static final String HTTP_LOCALHOST_8001_BOOKS = "http://localhost:8000/books";

    @Autowired
    private FeignClientForMicroserviceOne feignClientForMicroserviceOne;

    @RequestMapping("/")
    public String home() {
        return "Hello World! " + appName;
    }

    @PostMapping("/books-to-ms-1")
    public String addBookIndirectly(@NotNull @RequestBody String bookName) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ms 2", " processed query");
        jsonObject.put("ms 1 response", feignClientForMicroserviceOne.client1response(bookName));
        return jsonObject.toString();
    }
}
