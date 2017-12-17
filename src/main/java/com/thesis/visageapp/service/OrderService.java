package com.thesis.visageapp.service;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    void processOrder(String productId, int count) throws SQLException;

    String order(List<String> productsIds, String userId) throws IllegalAccessException, SQLException;
}
