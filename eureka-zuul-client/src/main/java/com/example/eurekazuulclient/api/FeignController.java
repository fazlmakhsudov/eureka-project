package com.example.eurekazuulclient.api;

import com.example.eurekazuulclient.feign_clients.FeignClientForMicroserviceTwo;
import com.example.eurekazuulclient.services.BookService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller using feign client
 *
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 20:28
 */
@RestController
public class FeignController {

    @Autowired
    private FeignClientForMicroserviceTwo feignClientForMicroserviceTwo;

    @Autowired
    private BookService bookService;

    @GetMapping("/book-with-ms2")
    public String getResponses() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("book", bookService.getRandomBook());
        jsonObject.put("micro service 2", feignClientForMicroserviceTwo.client3Response());
        return jsonObject.toString();
    }
}
