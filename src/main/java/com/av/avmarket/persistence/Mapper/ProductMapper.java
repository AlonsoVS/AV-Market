package com.av.avmarket.persistence.Mapper;

import com.av.avmarket.domain.ProductDomain;
import com.av.avmarket.persistence.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

  @Mappings({
          @Mapping(source = "productId", target = "id"),
          @Mapping(source = "name", target = "name"),
          @Mapping(source = "categoryId", target = "categoryId"),
          @Mapping(source = "salePrice", target = "price"),
          @Mapping(source = "stockQuantity", target = "stock"),
          @Mapping(source = "status", target = "active"),
          @Mapping(source = "category", target = "category"),
  })
  ProductDomain toProductDomain(Product product);
  List<ProductDomain> toProductsDomain(List<Product> products);

  @InheritInverseConfiguration
  @Mapping(target = "barcode", ignore = true)
  Product toProduct(ProductDomain productDomain);
}
