package com.av.avmarket.web.controller;

import com.av.avmarket.domain.ProductDomain;
import com.av.avmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  public List<ProductDomain> getAll() {return productService.getAll();}

  public Optional<ProductDomain> getProduct(int productId) {return productService.getProduct(productId);}

  public Optional<List<ProductDomain>> getByCategory(int categoryId) {return productService.getByCategory(categoryId);}

  public ProductDomain save(ProductDomain productDomain) {return productService.save(productDomain);}

  public boolean delete(int productId) {return productService.delete(productId);}
}
