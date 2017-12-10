package com.thesis.visageapp.service;

import java.sql.SQLException;

public interface OrderService {

    void processOrder(String productId, int count) throws SQLException;
}
