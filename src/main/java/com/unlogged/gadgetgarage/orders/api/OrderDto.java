package com.unlogged.gadgetgarage.orders.api;


import java.util.List;

public record OrderDto(
        Long id,
        List<OrderItemDto> items,
        String status
) {}

