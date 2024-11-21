package com.unlogged.gadgetgarage.orders.events;

import com.unlogged.gadgetgarage.orders.api.OrderItemDto;

import java.util.List;

public record OrderCreatedEvent(
        Long orderId,
        List<OrderItemDto> items,
        String status
) {
}