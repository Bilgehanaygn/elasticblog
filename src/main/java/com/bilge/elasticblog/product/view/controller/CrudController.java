package com.bilge.elasticblog.product.view.controller;


import com.bilge.elasticblog.product.service.ProductCrudService;
import com.bilge.elasticblog.product.view.dto.ProductCrudDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class CrudController {

  private final ProductCrudService productCrudService;

  public CrudController(ProductCrudService productCrudService) {
    this.productCrudService = productCrudService;
  }

  @PostMapping
  private Long create(@RequestBody ProductCrudDto productCrudDto) {
    return productCrudService.create(productCrudDto);
  }
}
