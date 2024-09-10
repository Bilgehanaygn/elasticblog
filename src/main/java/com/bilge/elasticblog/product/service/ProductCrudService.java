package com.bilge.elasticblog.product.service;


import com.bilge.elasticblog.product.jpa.Product;
import com.bilge.elasticblog.product.jpa.ProductJpaRepository;
import com.bilge.elasticblog.product.view.dto.ProductCrudDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductCrudService {

  private final ProductJpaRepository productJpaRepository;

  public ProductCrudService(ProductJpaRepository productJpaRepository) {
    this.productJpaRepository = productJpaRepository;
  }

  public Long create(ProductCrudDto productCrudDto) {
    Product product = new Product(-1L, productCrudDto.name());
    return productJpaRepository.save(product).getId();
  }
}
