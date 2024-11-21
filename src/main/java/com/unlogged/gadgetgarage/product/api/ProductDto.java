package com.unlogged.gadgetgarage.product.api;

public record ProductDto(
        Long id,
        String name,
        String description,
        Double price
) {
}