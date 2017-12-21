package com.thesis.visageapp.controller.rest;

import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.service.ProductService;
import com.thesis.visageapp.service.impl.AndroidPushNotificationsServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class NotificationController {


    @Autowired
    private ProductService productService;

    private String Topic;
    private byte[] encodedBytes;

    @Autowired
    AndroidPushNotificationsServiceImpl androidPushNotificationsService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(@RequestParam("id") String productId) throws JSONException, IllegalAccessException {
        Product product = productService.getProductWithId(productId);
        Topic = productId;
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + Topic);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "MakeMeUp");
        encodedBytes = Base64.getEncoder().encode("Twój ulubiony produkt jest już dostępny !".getBytes());
        notification.put("body", "" + new String(encodedBytes));

        JSONObject data = new JSONObject();
        data.put("productId","" + productId);
        encodedBytes = Base64.getEncoder().encode(product.getName().getBytes());
        data.put("productName","" + new String(encodedBytes));
        data.put("image", "" + product.getImageLink());

        body.put("notification", notification);
        body.put("data", data);

/**
 {
 "notification": {
 "title": "JSA Notification",
 "body": "Happy Message!"
 },
 "data": {
 "Key-1": "JSA Data 1",
 "Key-2": "JSA Data 2"
 },
 "to": "/topics/JavaSampleApproach",
 "priority": "high"
 }
 */

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            //return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
            return "redirect:/products/all";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "Push Notification ERROR!";
    }
}