package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.Delivery;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agatka on 15.10.2017.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addDelivery(Delivery deliveryToBeAdded) {
        String result = this.executeDelivery(deliveryToBeAdded);
    }

    private String executeDelivery(Delivery deliveryToBeAdded) {
        MultipartFile file = deliveryToBeAdded.getFile();
        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {

            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result.stream().reduce("",String::concat);
        //TODO: it is random stream, deliveryController isn't implemented properly :(
    }
}


