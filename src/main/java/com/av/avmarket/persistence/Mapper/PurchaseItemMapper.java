package com.av.avmarket.persistence.Mapper;

import com.av.avmarket.domain.PurchaseItem;
import com.av.avmarket.persistence.entity.ProductSale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

  @Mappings ({
          @Mapping(source = "id.productId", target = "productId"),
          @Mapping(source = "quantity", target = "quantity"),
          @Mapping(source = "quantity", target = "total"),
          @Mapping(source = "status", target = "active")
  })
  PurchaseItem toPurchaseItem(ProductSale product);

  @InheritInverseConfiguration
  @Mappings({
          @Mapping(target = "sale", ignore = true),
          @Mapping(target = "product", ignore = true),
          @Mapping(target = "id.saleId", ignore = true)
  })
  ProductSale toProductSale(PurchaseItem item);
}
