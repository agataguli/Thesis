package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.repository.OrderItemRepository;
import com.thesis.visageapp.domain.repository.OrderRepository;
import com.thesis.visageapp.domain.repository.impl.StaticQueryParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.OrderService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void processOrder(String productId, int count) throws SQLException {

        try {
            Product productById = this.productRepository.getProductWithId(productId);
            if (productById.getQuantity() < count) {
                throw new IllegalArgumentException("Quantity of product: " + productId + "is out off stock, current quantity:" + productById.getQuantity());
            }
            productById.setQuantity(productById.getQuantity() - count);
            this.productRepository.changeQuantity(productById.getQuantity(), productById.getProductId());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String order(List<String> productsIds, String userId) throws IllegalAccessException, SQLException {
        Map<String, Integer> groupedByQuantityAndIds = this.groupByIds(productsIds);
        String response = this.productRepository.checkAreProductsAvailable(groupedByQuantityAndIds);
        if (!response.equalsIgnoreCase(StaticQueryParts.RESPONSE_CODE_SUCCESS)) {
            return response;
        }
        Double totalGrossValue = this.calculateTotalGrossValue(productsIds);
        String orderId = this.orderRepository.createOrder(userId, totalGrossValue);
        groupedByQuantityAndIds.forEach((k, v) -> {
            try {
                this.productRepository.changeQuantity(v, k);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        for (String productId : productsIds) {
            this.orderItemRepository.createOrderItem(productId, this.productRepository.getProductWithId(productId).getGrossValue(), orderId);
        }
        return response + "_" + orderId;
    }

    private Double calculateTotalGrossValue(List<String> productsIds) throws IllegalAccessException {
        Double total = 0.0;
        for (String productId : productsIds) {
            total += this.productRepository.getProductWithId(productId).getGrossValue();
        }
        total = new BigDecimal(total.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return total;
    }

    private Map<String, Integer> groupByIds(List<String> productsIds) {
        Map<String, Integer> groupedByIdsAndQuantity = new HashMap<>();
        for (String productId : productsIds) {
            if (groupedByIdsAndQuantity.containsKey(productId)) {
                groupedByIdsAndQuantity.replace(productId, groupedByIdsAndQuantity.get(productId) + 1);
            } else groupedByIdsAndQuantity.put(productId, 1);
        }
        return groupedByIdsAndQuantity;
    }
}
