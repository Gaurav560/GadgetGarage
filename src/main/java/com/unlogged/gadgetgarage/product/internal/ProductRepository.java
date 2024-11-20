package com.unlogged.gadgetgarage.product.internal;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {
}