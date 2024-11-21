package com.unlogged.gadgetgarage.orders.api;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(List<OrderItemDto> items);
    OrderDto findOrder(Long id);
    List<OrderDto> findAllOrders();
}