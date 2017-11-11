package com.thesis.visageapp.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class Delivery {
    String deliveryId;
    Date date;
    MultipartFile file;


    public Delivery(String deliveryId, Date date, MultipartFile file) {
        this.deliveryId = deliveryId;
        this.date = date;
        this.file = file;
    }

    public Delivery() {
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
