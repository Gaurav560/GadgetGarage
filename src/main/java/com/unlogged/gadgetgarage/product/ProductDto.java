package com.unlogged.gadgetgarage.product;

public record ProductDto(
        Long id,
        String name,
        String description,
        Double price
) {
}