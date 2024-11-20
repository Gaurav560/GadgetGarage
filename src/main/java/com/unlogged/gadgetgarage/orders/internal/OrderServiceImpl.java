package com.unlogged.gadgetgarage.orders.internal;

import com.unlogged.gadgetgarage.orders.OrderDto;
import com.unlogged.gadgetgarage.orders.OrderItemDto;
import com.unlogged.gadgetgarage.orders.OrderService;
import com.unlogged.gadgetgarage.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public OrderDto createOrder(List<OrderItemDto> items) {
        // Verify all products exist
        items.forEach(item -> productService.findProduct(item.productId()));

        Order order = new Order();
        order.setItems(items.stream()
                .map(this::toOrderItem)
                .collect(Collectors.toList()));
        order.setStatus("CREATED");

        order = orderRepository.save(order);
        return toDto(order);
    }

    @Override
    public OrderDto findOrder(Long id) {
        return orderRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getItems().stream()
                        .map(item -> new OrderItemDto(item.getProductId(), item.getQuantity()))
                        .collect(Collectors.toList()),
                order.getStatus()
        );
    }

    private OrderItem toOrderItem(OrderItemDto dto) {
        OrderItem item = new OrderItem();
        item.setProductId(dto.productId());
        item.setQuantity(dto.quantity());
        return item;
    }
}