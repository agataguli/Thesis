package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Delivery;

import java.sql.SQLException;

public interface DeliveryService {
    void addDelivery(Delivery deliveryToBeAdded) throws SQLException, IllegalAccessException;
}
