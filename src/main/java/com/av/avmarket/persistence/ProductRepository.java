package com.av.avmarket.persistence;

import com.av.avmarket.persistence.crud.ProductCrudRepository;
import com.av.avmarket.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {

  private ProductCrudRepository productCrudRepository;

  public List<Product> getAll() {return (List<Product>) productCrudRepository.findAll();}

  public List<Product> getByCategory(int categoryId) {return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);}

  public Optional<List<Product>> getScarce(int quantity) {return productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);}
}
