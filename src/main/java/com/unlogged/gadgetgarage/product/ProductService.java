package com.unlogged.gadgetgarage.product;

import java.util.List;

public interface ProductService {
    ProductDto findProduct(Long id);
    ProductDto createProduct(ProductDto product);
    void updateProduct(Long id, ProductDto product);
    List<ProductDto> findAllProducts();
}