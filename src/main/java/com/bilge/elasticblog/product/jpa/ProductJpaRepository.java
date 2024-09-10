package com.bilge.elasticblog.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
