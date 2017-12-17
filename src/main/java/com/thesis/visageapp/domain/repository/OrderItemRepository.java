package com.thesis.visageapp.domain.repository;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemRepository {
    List getAllOrderItem();

    String createOrderItem(String productId, Double value, String orderId) throws SQLException;
}
