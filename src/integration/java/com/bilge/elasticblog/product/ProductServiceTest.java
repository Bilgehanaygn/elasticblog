package com.bilge.elasticblog.product;


import com.bilge.elasticblog.configuration.annotations.DatabaseTest;
import com.bilge.elasticblog.product.jpa.Product;
import com.bilge.elasticblog.product.jpa.ProductJpaRepository;
import com.bilge.elasticblog.product.service.ProductCrudService;
import com.bilge.elasticblog.product.view.dto.ProductCrudDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.assertj.core.api.Assertions.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DatabaseTest
public class ProductServiceTest {

  @Autowired
  private ProductJpaRepository productJpaRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  private ProductCrudService productCrudService;

  @BeforeEach
  void init(){
    productCrudService = new ProductCrudService(productJpaRepository);
  }

  @Test
  public void savesSuccessfully(){
    var productCrudDto = new ProductCrudDto("test name 12");
    var savedEntityId = productCrudService.create(productCrudDto);

    var savedEntity = testEntityManager.find(Product.class, savedEntityId);
    Assertions.assertThat(savedEntity.getName()).isEqualTo("test name 12");
  }

}
