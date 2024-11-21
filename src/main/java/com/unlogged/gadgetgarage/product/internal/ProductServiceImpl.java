package com.unlogged.gadgetgarage.product.internal;

import com.unlogged.gadgetgarage.product.api.ProductDto;
import com.unlogged.gadgetgarage.product.api.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public ProductDto findProduct(Long id) {
        return productRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        Product product = toEntity(dto);
        product = productRepository.save(product);
        return toDto(product);
    }

    @Override
    public void updateProduct(Long id, ProductDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        updateEntity(product, dto);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    private Product toEntity(ProductDto dto) {
        Product product = new Product();
        updateEntity(product, dto);
        return product;
    }

    private void updateEntity(Product product, ProductDto dto) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
    }




}