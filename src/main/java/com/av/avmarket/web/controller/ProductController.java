package com.av.avmarket.web.controller;

import com.av.avmarket.domain.ProductDomain;
import com.av.avmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public List<ProductDomain> getAll() {return productService.getAll();}

  @GetMapping("/{id}")
  public Optional<ProductDomain> getProduct(@PathVariable("id") int productId) {return productService.getProduct(productId);}

  @GetMapping("/category/{categoryId}")
  public Optional<List<ProductDomain>> getByCategory(@PathVariable("categoryId") int categoryId) {return productService.getByCategory(categoryId);}

  @PostMapping("/save")
  public ProductDomain save(@RequestBody ProductDomain productDomain) {return productService.save(productDomain);}

  @DeleteMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int productId) {return productService.delete(productId);}
}
