package com.av.avmarket.persistence.crud;

import com.av.avmarket.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository <Product, Integer> {

  //@Query(value = "SELECT * FROM productos WHERE id_categorias = ? ", nativeQuery = true)
  List<Product> findByCategoryIdOrderByNameAsc(int categoryId);
  Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);
}
