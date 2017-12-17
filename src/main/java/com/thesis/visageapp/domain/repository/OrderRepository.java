package com.thesis.visageapp.domain.repository;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {
    public List getAllOrders();

    public String createOrder(String userId, Double totalGrossValue) throws SQLException;
}
