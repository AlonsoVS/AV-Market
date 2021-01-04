package com.av.avmarket.persistence;

import com.av.avmarket.domain.ProductDomain;
import com.av.avmarket.domain.repository.ProductRepository;
import com.av.avmarket.persistence.Mapper.ProductMapper;
import com.av.avmarket.persistence.crud.ProductCrudRepository;
import com.av.avmarket.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  private ProductCrudRepository productCrudRepository;

  private ProductMapper mapper;

  @Override
  public List<ProductDomain> getAll() {
    List<Product> products = (List<Product>) productCrudRepository.findAll();
    return mapper.toProductsDomain(products);
  }

  @Override
  public Optional<List<ProductDomain>> getByCategory(int categoryId) {
    List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
    return Optional.of(mapper.toProductsDomain(products));
  }

  @Override
  public Optional<List<ProductDomain>> getScarceProducts(int quantity) {
    Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
    return products.map(prods -> mapper.toProductsDomain(prods));
  }

  @Override
  public Optional<ProductDomain> getProduct(int productId) {
    return productCrudRepository.findById(productId).map(product -> mapper.toProductDomain(product));
  }

  @Override
  public ProductDomain save(ProductDomain productDomain) {
    Product product = mapper.toProduct(productDomain);
    return mapper.toProductDomain(productCrudRepository.save(product));
  }

  @Override
  public void delete(int productId) {productCrudRepository.deleteById(productId);}
}
